package com.platform.bookshare.view.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.platform.bookshare.R;
import com.platform.bookshare.zxing.camera.CameraManager;
import com.platform.bookshare.zxing.decode.DecodeThread;
import com.platform.bookshare.zxing.utils.BeepManager;
import com.platform.bookshare.zxing.utils.CaptureActivityHandler;
import com.platform.bookshare.zxing.utils.InactivityTimer;
import com.google.zxing.Result;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * 说明：扫描二维码，获得扫描结果页面
 * --JSJ--
 * 2016-11-20
 */
public final class CaptureActivity extends Activity implements SurfaceHolder.Callback {
    private static final String TAG = "CaptureActivity";

    private Context context;
    private CameraManager cameraManager;
    private CaptureActivityHandler handler;
    private InactivityTimer inactivityTimer;
    private BeepManager beepManager;

    private SurfaceView scanPreview = null;
    private RelativeLayout scanContainer;
    private RelativeLayout scanCropView;
    private ImageView scanLine;
    private TextView titleTv;
    private RelativeLayout backRl;
    private Rect mCropRect = null;

    public Handler getHandler() {
        return handler;
    }

    public CameraManager getCameraManager() {
        return cameraManager;
    }

    private boolean isHasSurface = false;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        context=this;
        setRootView();
        initWidget();
    }

    @Override
    protected void onResume() {
        super.onResume();
        cameraManager = new CameraManager(getApplication());
        handler = null;
        if (isHasSurface) {
            // The activity was paused but not stopped, so the surface still
            // exists. Therefore
            // surfaceCreated() won't be called, so init the camera here.
            initCamera(scanPreview.getHolder());
        } else {
            // Install the callback and wait for surfaceCreated() to init the
            // camera.
            scanPreview.getHolder().addCallback(this);
        }

        inactivityTimer.onResume();
    }

    @Override
    protected void onPause() {
        if (handler != null) {
            handler.quitSynchronously();
            handler = null;
        }
        inactivityTimer.onPause();
        beepManager.close();
        cameraManager.closeDriver();
        if (!isHasSurface) {
            scanPreview.getHolder().removeCallback(this);
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        inactivityTimer.shutdown();
        super.onDestroy();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        if (holder == null) {
            Log.e("demo","*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!isHasSurface) {
            isHasSurface = true;
            initCamera(holder);
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isHasSurface = false;
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    }

    /**
     * A valid barcode has been found, so give an indication of success and show
     * the results.
     *
     * @param rawResult The contents of the barcode.
     * @param bundle    The extras
     */
    public void handleDecode(Result rawResult, Bundle bundle) {
        inactivityTimer.onActivity();
//        beepManager.playBeepSoundAndVibrate();

        //http://www.haoban.cn/user/info/{id}  二维码客户端生成，这个是要生成的字符串   id-用户ID
        //http://www.haoban.cn/group/info/{id}
        String resultString = rawResult.getText();
        Log.v("二维码结果：", resultString);
        if (resultString.equals("")) {
            Log.i("demo","无法访问此二维码");
        } else {
            Intent it = new Intent();
            String result = rawResult.getText();
//            ViewInject.toast(result);
            if (result.contains("www.haoban.cn")) {
                int pos = result.indexOf("info/");
                if (result.contains("user")) {
                    String substr = result.substring(pos + 6, result.length() - 1);
                    if (substr.equals("null") || substr.equals("(null)") || substr.equals("{(null)}")) {
                        Log.i("demo","无法访问此二维码");
                        return;
                    }
                    it.putExtra("ID", substr);

                } else {
                    String teamid = result.substring(pos + 6, result.length() - 1);
                    if (teamid.equals("null") || teamid.equals("(null)") || teamid.equals("{(null)}")) {
                        Log.i("demo","无法访问此二维码");
                        return;
                    }
                    Log.d(TAG, "二维码测试    " + teamid);
                    it.putExtra("Flag", 1);
                    it.putExtra("ChatID", teamid);
                }
                startActivity(it);
            } else {//用于首页、我扫码功能
                Log.v("demo","扫码结果：" + result);
                //通知后台是否绑定用户-转换地址（主要作用）
                String userAgent = null;
                if (result.contains("ai=")) {
                    userAgent = result.substring(result.indexOf("ai=") + 3);
                    if(userAgent.contains("&")) {
                        userAgent = userAgent.substring(0, userAgent.indexOf("&"));
                    }else{
                        userAgent = userAgent.trim();
                    }
                }

            }
        }
        Intent intent = new Intent(CaptureActivity.this,BookInfoActivity.class);
        intent.putExtra("isbnNum",resultString);
        startActivity(intent);
        System.out.println("this is over+.............");
//        CaptureActivity.this.finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        }
        if (cameraManager.isOpen()) {
            Log.w("demo","initCamera() while already open -- late SurfaceView callback?");
            return;
        }
        try {
            cameraManager.openDriver(surfaceHolder);
            // Creating the handler starts the preview, which can also throw a
            // RuntimeException.
            if (handler == null) {
                handler = new CaptureActivityHandler(this, cameraManager,
                        DecodeThread.ALL_MODE);
            }

            initCrop();
        } catch (IOException ioe) {
            Log.w(TAG, ioe);
            displayFrameworkBugMessageAndExit();
        } catch (RuntimeException e) {
            // Barcode Scanner has seen crashes in the wild of this variety:
            // java.?lang.?RuntimeException: Fail to connect to camera service
            Log.w(TAG, "Unexpected error initializing camera", e);
            displayFrameworkBugMessageAndExit();
        }
    }

    private void displayFrameworkBugMessageAndExit() {
        // camera error
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.app_name));
        builder.setMessage("你的相机权限没有打开；请打开“设置-隐私-相机”，找到“好班APP”后进行设置");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }

        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                finish();
            }
        });
        builder.show();
    }

    public void restartPreviewAfterDelay(long delayMS) {
        if (handler != null) {
            handler.sendEmptyMessageDelayed(R.id.restart_preview, delayMS);
        }
    }

    public Rect getCropRect() {
        return mCropRect;
    }

    /**
     * 初始化截取的矩形区域
     */
    private void initCrop() {
        int cameraWidth = cameraManager.getCameraResolution().y;
        int cameraHeight = cameraManager.getCameraResolution().x;

        /** 获取布局中扫描框的位置信息 */
        int[] location = new int[2];
        scanCropView.getLocationInWindow(location);

        int cropLeft = location[0];
        int cropTop = location[1] - getStatusBarHeight();

        int cropWidth = scanCropView.getWidth();
        int cropHeight = scanCropView.getHeight();

        /** 获取布局容器的宽高 */
        int containerWidth = scanContainer.getWidth();
        int containerHeight = scanContainer.getHeight();

        /** 计算最终截取的矩形的左上角顶点x坐标 */
        int x = cropLeft * cameraWidth / containerWidth;
        /** 计算最终截取的矩形的左上角顶点y坐标 */
        int y = cropTop * cameraHeight / containerHeight;

        /** 计算最终截取的矩形的宽度 */
        int width = cropWidth * cameraWidth / containerWidth;
        /** 计算最终截取的矩形的高度 */
        int height = cropHeight * cameraHeight / containerHeight;

        /** 生成最终的截取的矩形 */
        mCropRect = new Rect(x, y, width + x, height + y);
    }

    private int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void setRootView() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 竖屏锁定
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
        setContentView(R.layout.activity_capture);
//        ctxbase = CaptureActivity.this;
    }

//    @Override
    public void initWidget() {
//        super.initWidget();
        // title_text.setText(R.string.pop_sweep);
        backRl = (RelativeLayout)findViewById(R.id.back_rl);
        scanPreview = (SurfaceView) findViewById(R.id.capture_preview);
        scanContainer = (RelativeLayout) findViewById(R.id.capture_container);
        scanCropView = (RelativeLayout) findViewById(R.id.capture_crop_view);
        scanLine = (ImageView) findViewById(R.id.capture_scan_line);

        backRl.setVisibility(View.VISIBLE);

        inactivityTimer = new InactivityTimer(this);
        beepManager = new BeepManager(this);

        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.9f);
        animation.setDuration(4500);
        animation.setRepeatCount(-1);
        animation.setRepeatMode(Animation.RESTART);
        // back.setOnClickListener(new OnClickListener() {
        //
        // @Override
        // public void onClick(View v) {
        // CaptureActivity.this.finish();
        // }
        // });
        scanLine.startAnimation(animation);
    }


}