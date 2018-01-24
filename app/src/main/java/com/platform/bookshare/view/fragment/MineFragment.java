package com.platform.bookshare.view.fragment;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.FileUtils;
import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.platform.bookshare.utils.PhotoViewUtils;
import com.platform.bookshare.utils.imageutils.CropImageActivity;
import com.platform.bookshare.utils.view.CircleImage;
import com.platform.bookshare.view.configer.Configer;

import org.kymjs.kjframe.ui.ViewInject;

import java.io.File;
import java.util.Date;

import static android.app.Activity.RESULT_OK;
import static com.platform.bookshare.utils.PhotoViewUtils.FLAG_CHOOSE_IMG;
import static com.platform.bookshare.utils.PhotoViewUtils.FLAG_CHOOSE_PHONE;
import static com.platform.bookshare.utils.PhotoViewUtils.FLAG_MODIFY_FINISH;

/**
 * 功能：个人中心fragment
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private CircleImage meCirHead;
    private TextView meTvNickName;
    private ImageView meImgBack;
    private LinearLayout meLinMain;

    private Context context;
    private AppCompatActivity appCompatActivity;

//    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA)
//            == PackageManager.PERMISSION_GRANTED) {
//        //init(barcodeScannerView, getIntent(), null);
//    } else {
//        ActivityCompat.requestPermissions(this,
//                new String[]{Manifest.permission.CAMERA}, 1);//1 can be another integer
//    }
    @Override
    public int getResource() {
        context = getActivity();
        appCompatActivity = (AppCompatActivity) context;
        return R.layout.fragment_mine;
    }

    @Override
    public void init(View view) {
        meImgBack = (ImageView) view.findViewById(R.id.fragme_imgback);
        meTvNickName = (TextView) view.findViewById(R.id.fragme_tvnickname);
        meCirHead = (CircleImage) view.findViewById(R.id.fragme_circlehead);
        meLinMain = (LinearLayout) view.findViewById(R.id.fragme_linmain);

        meCirHead.setOnClickListener(this);
    }

    @Override
    public void loadingDatas() {

    }

    @Override
    public void startdestroy() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragme_circlehead:
                PhotoViewUtils.openCamera(context);
//                opCam(context);
                break;
        }
    }

    private void opCam(Context context) {
//        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {

        } else {
            ActivityCompat.requestPermissions((Activity) context,
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
                Log.e("文件相关",f.getAbsolutePath().toString());
                if (FileUtils.createOrExistsFile(f)) {
                    Log.e("文件相关","运行到此处");
                    Uri u = Uri.fromFile(f);
                    intent.putExtra(MediaStore.Images.Media.ORIENTATION, 0);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                    appCompatActivity.startActivityForResult(intent, FLAG_CHOOSE_PHONE);
                } else {
                    ViewInject.toast("拍照失败");
                    Log.e("文件相关","运行到此处error");
                }
            } catch (Exception e) {
                //
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FLAG_CHOOSE_IMG && resultCode == RESULT_OK) {
            if (data != null) {
                PhotoViewUtils.beginCrop(context,data);
            }
        } else if (requestCode == FLAG_CHOOSE_PHONE && resultCode == RESULT_OK) {
            File f = new File(Configer.FILE_PIC_PATH);
            boolean orExistsDir = FileUtils.createOrExistsFile(f);
            if (orExistsDir) {
                Intent it = new Intent(context, CropImageActivity.class);
                it.putExtra("path", f.getAbsolutePath());
                startActivityForResult(it, FLAG_MODIFY_FINISH);
            } else {
                ViewInject.toast("没有获取到照片，请重新拍照");
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
                Glide.with(context).load(file).centerCrop().into(meCirHead);
//                KJHttpUtil.httpFilesend(context, file, filecall); //上传头像
            }
        }
    }
}
