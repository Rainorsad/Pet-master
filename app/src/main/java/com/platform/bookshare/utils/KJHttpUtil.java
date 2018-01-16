package com.platform.bookshare.utils;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import com.platform.bookshare.config.UrlConfig;

import org.kymjs.kjframe.KJHttp;
import org.kymjs.kjframe.http.HttpCallBack;
import org.kymjs.kjframe.http.HttpConfig;
import org.kymjs.kjframe.http.HttpParams;
import org.kymjs.kjframe.ui.ViewInject;
import org.kymjs.kjframe.utils.SystemTool;


/**
 * 时间： 2016/11/10 10:58
 * ---ZWQ---
 */
public class KJHttpUtil {
    private static final String TAG = "KJHttpUtil";
    private static final String MY_APP_NAME="HaoBan";
    private static final String MY_APP_VERSION_NAME = "1.0";

    private static long time = System.currentTimeMillis();
    private static KJHttp kjh;
    private static int channelType;

    private static KJHttp getKjHttp() {
        if (kjh == null) {
            HttpConfig config = new HttpConfig();
            //超时时间
            config.TIMEOUT = 1000 * 15;
            kjh = new KJHttp();
        }

        return kjh;
    }

    public static void getHttp(Context context, String url, HttpParams httpParams, boolean isCache,
                               HttpCallBack CallBack) {
        getHttp(context, url, httpParams, isCache, CallBack,  0);
    }

    /**
     * 框架中的get请求
     *
     * @param context     上下文
     * @param url         接口
     * @param httpParams  参数
     * @param isCache     是否缓存
     * @param CallBack    回调
     * @param all         总实体中条目个数
     */
    public static void getHttp(Context context, String url, HttpParams httpParams, boolean isCache,
                               HttpCallBack CallBack, int all) {
        if (SystemTool.checkNet(context)) {//检测网络
            httpParams.putHeaders("User-Agent", String.format("%s/%s (Linux; Android %s; %s Build/%s)", MY_APP_NAME, MY_APP_VERSION_NAME, Build.VERSION.RELEASE, Build.MANUFACTURER, Build.ID)+ " ShareBook/"+MY_APP_VERSION_NAME);
            getKjHttp().get(url, httpParams, isCache, CallBack);
            // AutoLog.v("打印请求头usreAgent参数："+String.format("%s/%s (Linux; Android %s; %s Build/%s)", MY_APP_NAME, MY_APP_VERSION_NAME, Build.VERSION.RELEASE, Build.MANUFACTURER, Build.ID)+ " HaoBan/"+MY_APP_VERSION_NAME);
        } else {
            long nowTime = System.currentTimeMillis();
            if (nowTime - time > 3000) {
                ViewInject.toast("网络不可用，请检查网络设置");
                time = System.currentTimeMillis();
            }
            //  没有网路

        }
    }

    public static void getBookByIsbn(Context context, String url, HttpParams httpParams, boolean isCache,HttpCallBack callBack) {
        // Config.BaseUrlLogin + Config.login
//        kjh = null;
//        HttpConfig config = new HttpConfig();
////		config.mNetwork = new Network(null);
//        kjh = new KJHttp(config);
//        HttpParams params = new HttpParams();
//        params.put("post_data", "xxx");

        getKjHttp().get(url, httpParams, callBack);
    }



}
