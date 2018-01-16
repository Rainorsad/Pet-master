package com.platform.bookshare.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ViewFlipper;

import com.platform.bookshare.R;
import com.platform.bookshare.view.view.wowsplash.WowSplashView;
import com.platform.bookshare.view.view.wowsplash.WowView;


/**
 * Created by Zhangchen on 2018/1/15.
 */

public class StartActivity extends BaseActivity{

    private ViewFlipper flipper;
    private GestureDetector detector;
    private WowSplashView mWowSplashView;
    private WowView mWowView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        context = this;

        setData();
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

}
