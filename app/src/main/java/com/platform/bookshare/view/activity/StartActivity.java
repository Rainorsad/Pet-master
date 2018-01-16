package com.platform.bookshare.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ViewFlipper;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.platform.bookshare.R;
import com.platform.bookshare.view.view.wowsplash.WowSplashView;
import com.platform.bookshare.view.view.wowsplash.WowView;


/**
 * Created by Zhangchen on 2018/1/15.
 */

public class StartActivity extends BaseActivity{

    private String TAG = "StartActivity";
    private ViewFlipper flipper;
    private GestureDetector detector;
    private WowSplashView mWowSplashView;
    private WowView mWowView;
    private Context context;

    private LocationClient mLocationClient;
    private BDLocationListener mBDLocaListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        context = this;

        getLocation();
        setData();
    }

    /**
     * 获得经纬度
     */
    private void getLocation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        mLocationClient = new LocationClient(this);
        mBDLocaListener = new MyBDLocationListener();
        mLocationClient.registerLocationListener(mBDLocaListener);

        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);
        option.setCoorType("db0911");
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);
        option.setNeedDeviceDirect(true);
        mLocationClient.setLocOption(option);
        mLocationClient.start();
    }

    public void setData() {
        mWowSplashView = (WowSplashView) findViewById(R.id.wowSplash);
        mWowView = (WowView) findViewById(R.id.wowView);

        mWowSplashView.startAnimate();

        mWowSplashView.setOnEndListener(new WowSplashView.OnEndListener() {
            @Override public void onEnd(WowSplashView wowSplashView) {
                mWowSplashView.setVisibility(View.GONE);
                mWowView.setVisibility(View.VISIBLE);
                mWowView.startAnimate(wowSplashView.getDrawingCache(),context);

                mWowView.setOnEndListener(new WowView.OnEndListener() {
                    @Override
                    public void onEnd(WowView w) {
                        mWowView.setVisibility(View.GONE);
                        startActivity(new Intent(StartActivity.this,LeaderActivity.class));
                        StartActivity.this.finish();
                    }
                });
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (detector != null) {
            return detector.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLocationClient != null) {
            mLocationClient.unRegisterLocationListener(mBDLocaListener);
        }
    }

    private class MyBDLocationListener implements BDLocationListener{

        @Override
        public void onReceiveLocation(BDLocation location) {
            if (location != null){
                double latitude = location.getLatitude();
                double longitude = location.getLongitude();
                String address = location.getAddrStr();
                Log.e(TAG, "address:" + address + " latitude:" + latitude
                        + " longitude:" + longitude + "---");
                if (mLocationClient.isStarted()) {
                    // 获得位置之后停止定位
                    mLocationClient.stop();
                }
            }
        }
    }
}
