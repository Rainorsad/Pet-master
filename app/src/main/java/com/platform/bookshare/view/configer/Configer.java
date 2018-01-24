package com.platform.bookshare.view.configer;

import android.os.Environment;

/**
 * Created by Zhangchen on 2018/1/23.
 */

public class Configer {

    /**sd卡文件路径 -返回扩展存储区目录(SDCard)*/
    public static final String FILE_MAIN_PATH = Environment.getExternalStorageDirectory().toString() + "/BookShare";
    /**图片地址*/
    public static final String FILE_PIC_PATH =FILE_MAIN_PATH + "/image/";
}
