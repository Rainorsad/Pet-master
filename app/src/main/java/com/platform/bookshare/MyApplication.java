package com.platform.bookshare;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.blankj.utilcode.utils.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.zhy.autolayout.config.AutoLayoutConifg;
//import baidu.

public class MyApplication extends Application {

    public static String jingdu;
    public static String weidu;
    @Override
    public void onCreate()
    {
        super.onCreate();
        Utils.init(this);
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this,config);
        AutoLayoutConifg.getInstance().useDeviceSize();
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(getApplicationContext());
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

}
