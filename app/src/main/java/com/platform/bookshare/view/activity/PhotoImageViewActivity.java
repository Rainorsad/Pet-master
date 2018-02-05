package com.platform.bookshare.view.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.blankj.utilcode.utils.FileUtils;
import com.platform.bookshare.utils.imageutils.CropImageActivity;
import com.platform.bookshare.view.configer.Configer;

import org.kymjs.kjframe.ui.ViewInject;

import java.io.File;
import java.util.Date;

/**
 * Created by Zhangchen on 2018/1/25.
 */

public class PhotoImageViewActivity extends AppCompatActivity{

    private Context context;
    public static final int FLAG_CHOOSE_IMG = 5;// 从相册中选择
    public static final int FLAG_CHOOSE_PHONE = 6;// 拍照
    public static final int FLAG_MODIFY_FINISH = 7;// 结果

    private String localTempImageFileName;//拍照图片地址


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        Bundle extras = getIntent().getExtras();
        int img = extras.getInt("img");
        if (img == 1){
            //相机
            opemCame();
        }else if (img == 2){
            //相册
        }
    }

    /**
     * 打开相机
     */
    private void opemCame() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(PhotoImageViewActivity.this,
                    new String[]{Manifest.permission.CAMERA}, 1);//1 can be another integer
        }
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            try {
                localTempImageFileName = String.valueOf((new Date()).getTime())
                        + ".png";
                File filePath = new File(Configer.FILE_PIC_PATH);
                if (!filePath.exists()) {
                    filePath.mkdirs();
                }
                Intent intent = new Intent(
                        MediaStore.ACTION_IMAGE_CAPTURE);
                File f = new File(filePath, localTempImageFileName);
                if (FileUtils.createOrExistsFile(f)) {
                    Uri u = Uri.fromFile(f);
                    intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                } else {
                    ViewInject.toast("拍照失败");
                }
            } catch (Exception e) {
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FLAG_CHOOSE_IMG && resultCode == RESULT_OK) {
            if (data != null) {
                Uri uri = data.getData();
                if (!TextUtils.isEmpty(uri.getAuthority())) {
                    Cursor cursor = getContentResolver().query(uri,
                            new String[]{MediaStore.Images.Media.DATA},
                            null, null, null);
                    if (null == cursor) {
                        return;
                    }
                    cursor.moveToFirst();
                    String path = cursor.getString(cursor
                            .getColumnIndex(MediaStore.Images.Media.DATA));
                    cursor.close();
                    Intent intent = new Intent(context, CropImageActivity.class);
                    intent.putExtra("path", path);
                    startActivityForResult(intent, FLAG_MODIFY_FINISH);
                } else {
                    Intent intent = new Intent(this, CropImageActivity.class);
                    intent.putExtra("path", uri.getPath());
                    startActivityForResult(intent, FLAG_MODIFY_FINISH);
                }
            }
        } else if (requestCode == FLAG_CHOOSE_PHONE && resultCode == RESULT_OK) {
            File f = new File(Configer.FILE_PIC_PATH, localTempImageFileName);
            boolean orExistsDir = FileUtils.createOrExistsFile(f);
            if (orExistsDir) {
                Intent it = new Intent(context, CropImageActivity.class);
                it.putExtra("path", f.getAbsolutePath());
                startActivityForResult(it, FLAG_MODIFY_FINISH);
            } else {
                ViewInject.toast("没有获取到照片，请重新拍照");
                finish();
            }

        } else if (requestCode == FLAG_MODIFY_FINISH && resultCode == RESULT_OK) {
            if (data != null) {
                String path = data.getStringExtra("path");
                File file = new File(path);
                boolean orExistsDir = FileUtils.createOrExistsFile(file);
                if (!orExistsDir) {
                    ViewInject.toast("没有获取到照片，请重新选取");
                    return;
                }
            }
        }
    }
}
