package com.platform.bookshare.view.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.telephony.TelephonyManager;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.kymjs.kjframe.KJActivity;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.ui.KJActivityStack;
import org.kymjs.kjframe.ui.ViewInject;
import org.kymjs.kjframe.utils.PreferenceHelper;

import java.io.File;
import java.io.FileOutputStream;

/**
 * --ZWQ--
 * 2016-11-10
 */
public class BaseActivity extends KJActivity {
    private static final String TAG = "BaseActivity";
    private boolean destroyed = false;
    private ConnectionChangeReceiver connectionReceiver;
    private Context context;
    private static Context con;
    public static Context ctxbase;
    public boolean bconfilict = false;
    private ProgressDialog pd;
    protected ProgressDialog mProgressDialog;
    private Activity saveActivity;

    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

//        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
//        MobclickAgent.setSessionContinueMillis(300000); //5分钟在后台不再次计算
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        context = this;
        con = this;
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
        ImageLoader.getInstance().init(config);
    }

    @Override
    public void setRootView() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // 竖屏锁定
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 取消标题
    }

    public class ConnectionChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mobNetInfo = connectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            NetworkInfo wifiNetInfo = connectivityManager
                    .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            if (mobNetInfo == null && !wifiNetInfo.isConnected()) {
                ViewInject.toast("网络不可用，请检查网络设置");
//                AppLication.isOnline = 0;
                return;
            } else if (wifiNetInfo == null || (mobNetInfo != null &&
                    !mobNetInfo.isConnected() && !wifiNetInfo.isConnected())) {
//                AppLication.isOnline = 0;
                ViewInject.toast("网络不可用，请检查网络设置");
            } else {
//                AppLication.isOnline = 1;
            }
        }
    }

    @Override
    public void registerBroadcast() {
//        IntentFilter filter = new IntentFilter(com.tsingda.shopper.configer.Configer.ACTION_IM_ReceiveMessage);
//        IMReceiver = new IMReceiverMessage();
//        this.registerReceiver(IMReceiver, filter);
//
//        IntentFilter filter2 = new IntentFilter(
//               ConnectivityManager.CONNECTIVITY_ACTION);// 使用ConnectivityManager监听网络状态变化
//        connectionReceiver = new ConnectionChangeReceiver();
//        BaseActivity.this.registerReceiver(connectionReceiver, filter2);
    }

    @Override
    public void unRegisterBroadcast() {
        if (connectionReceiver != null) {
            BaseActivity.this.unregisterReceiver(connectionReceiver);
            connectionReceiver = null;
        }
    }

    protected void showKeyboard(boolean isShow) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (isShow) {
            if (getCurrentFocus() == null) {
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            } else {
                imm.showSoftInput(getCurrentFocus(), 0);
            }
        } else {
            if (getCurrentFocus() != null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    public static String readAppID(Context context) {
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (appInfo != null) {
                return appInfo.metaData.getString("com.netease.nim.appID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
//        AutoLog.d("PaymentActivity", "startActivity() called with: intent = [" + intent + "]");
    }

    // 注销
    private void onLogout() {

    }

    DialogInterface.OnClickListener onClick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
            //intent(LoginActivity.class);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
//        MobclickAgent.onPageStart("PageStart");
//        MobclickAgent.onResume(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
//            initGoldDialog();//初始金币弹窗
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
//        MobclickAgent.onPageEnd("PageEnd");
//        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyed = true;
    }

    protected boolean isCompatible(int apiLevel) {
        return android.os.Build.VERSION.SDK_INT >= apiLevel;
    }

    public boolean isDestroyedCompatible() {
        if (Build.VERSION.SDK_INT >= 17) {
            return isDestroyedCompatible17();
        } else {
            return destroyed || super.isFinishing();
        }
    }


    @TargetApi(17)
    private boolean isDestroyedCompatible17() {
        return super.isDestroyed();
    }

    /**
     * 跳转页面
     */
    public void intent(Class aClass) {
        //Intent intent = new Intent(getActivity(), aClass);
        Intent intent = new Intent(BaseActivity.this, aClass);
        startActivity(intent);
    }

    /**
     * 短信获得验证码
     *
     * @param userPhone      手机号
     * @param millisInFuture 等待时间
     * @param type           获取验证码入口 1(登录入口)，2(绑定手机号入口)，3(修改支付密码入口)
     * @param bt             验证码按钮
     * @param callBack       回调接口
     */
    public void getYanzhengma(Context c, String userPhone, long millisInFuture, int type, Button bt, HttpCallBack callBack) {
//        TimeCount time = new TimeCount(millisInFuture, bt);
//        time.start();
//        ViewInject.toast(getString(R.string.login_activity_verification_code));
//        KJHttpUtil.phoneCodeRequest(c, userPhone, 1, type, callBack);
    }

    class TimeCount extends CountDownTimer {
        private Button button;

        public TimeCount(long millisInFuture, Button bt) {
            super(millisInFuture, 1000);
            this.button = bt;
        }

        @Override
        public void onFinish() {// 计时完毕
            button.setText("点击获取验证码");
            button.setClickable(true);
        }

        @Override
        public void onTick(long millisUntilFinished) {// 计时过程
            button.setClickable(false);//防止重复点击
            button.setText(millisUntilFinished / 1000 + "秒");
        }
    }


    /**
     * 验证手机格式
     */
    public static boolean isMobile(String strnumber) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
//        String num = "[1][3578]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
//        if (TextUtils.isEmpty(number)) {
//            return false;
//        } else {
//            //matches():字符串是否在给定的正则表达式匹配
//            return number.matches(num);
//        }

        //新的需求，只判断号码是否为11位数字，其他不做处理 2017/05/22
        if (strnumber.length() != 11) {
            return false;
        }

        if (strnumber.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * 获取当前版本号
     *
     * @return
     */
    public String getVersionName() {
        PackageManager packageManager = getPackageManager();
        String s = null;
        try {
            PackageInfo info = packageManager.getPackageInfo(getPackageName(), 0);
            s = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     *
     * @return
     */
    public int getVersionCode() {
        PackageManager packageManager = getPackageManager();
        int versionCode = 0;
        try {
            PackageInfo info = packageManager.getPackageInfo(getPackageName(), 0);
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 判断网络是否是4G
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     *
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean is4G() {
        NetworkInfo info = getActiveNetworkInfo();
        return info != null && info.isAvailable() && info.getSubtype() == TelephonyManager.NETWORK_TYPE_LTE;
    }

    /**
     * 获取活动网络信息
     * <p>需添加权限 {@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}</p>
     *
     * @return NetworkInfo
     */
    private static NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) con
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    //滚动条显示
    public void startProgressDialog(String msg, Context context) {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
        pd = new ProgressDialog(context);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.setCanceledOnTouchOutside(false);
        pd.setMessage(msg);
        pd.setCancelable(false);
        pd.show();
    }

    //停止滚动条
    public void stopProgressDialog() {
        if (pd != null) {
            pd.dismiss();
            pd = null;
        }
    }

    //录制相关
    public ProgressDialog showProgress(String title, String message) {
        return showProgress(title, message, -1);
    }

    public ProgressDialog showProgress(String title, String message, int theme) {
        if (mProgressDialog == null) {
            if (theme > 0)
                mProgressDialog = new ProgressDialog(this, theme);
            else
                mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            mProgressDialog.setCanceledOnTouchOutside(false);// 不能取消
            mProgressDialog.setIndeterminate(true);// 设置进度条是否不明确

        }

        mProgressDialog.setMessage(message);
        mProgressDialog.show();
        return mProgressDialog;
    }

    public void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        hideProgress();
        mProgressDialog = null;
    }



}
