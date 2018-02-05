package com.platform.bookshare.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
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
 * Created by Zhangchen on 2018/1/23.
 */

public class PhotoViewUtils {

    public static final int FLAG_CHOOSE_IMG = 5;// 从相册中选择
    public static final int FLAG_CHOOSE_PHONE = 6;// 拍照
    public static final int FLAG_MODIFY_FINISH = 7;// 结果

    /**
     * 打开相机
     */
    public static Intent openCamera(FragmentActivity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.CAMERA}, 1);//1 can be another integer
        }
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            try {
                String localTempImageFileName = String.valueOf((new Date()).getTime())
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
                    return intent;
                } else {
                    ViewInject.toast("拍照失败");
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }else {
            return null;
        }
    }

    /**
     * 打开相册
     */
    public static void openPhoto(Context context) {
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setType("image/*");
        appCompatActivity.startActivityForResult(intent, FLAG_CHOOSE_IMG);
    }

    public static void beginCrop(Context context, Intent data) {
        Uri uri = data.getData();
        AppCompatActivity compatActivity = (AppCompatActivity) context;
        if (!TextUtils.isEmpty(uri.getAuthority())) {
            Cursor cursor = context.getContentResolver().query(uri,
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
            compatActivity.startActivityForResult(intent, FLAG_MODIFY_FINISH);
        } else {
            Intent intent = new Intent(context, CropImageActivity.class);
            intent.putExtra("path", uri.getPath());
            compatActivity.startActivityForResult(intent, FLAG_MODIFY_FINISH);
        }
    }
}
