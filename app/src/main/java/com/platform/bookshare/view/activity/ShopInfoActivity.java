package com.platform.bookshare.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.HomePageAdapter;
import com.platform.bookshare.view.fragment.ShopEvaluationFtagment;
import com.platform.bookshare.view.fragment.ShopFragment;
import com.platform.bookshare.view.fragment.ShopInfoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangchen on 2018/1/31.
 */

public class ShopInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private HomePageAdapter pageAdapter;
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private ImageView imgTitleLeft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopinfo);

        initview();
    }

    /**
     * 绑定控件
     */
    private void initview() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        imgTitleLeft = (ImageView) findViewById(R.id.imgtitle_left);

        imgTitleLeft.setOnClickListener(this);

        titles.add("商品");
        titles.add("详情");
        titles.add("评价");
        fragments.add(new ShopFragment());
        fragments.add(new ShopInfoFragment());
        fragments.add(new ShopEvaluationFtagment());

        pageAdapter = new HomePageAdapter(getSupportFragmentManager(),this,fragments,titles);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgtitle_left){
            finish();
        }
    }
}
