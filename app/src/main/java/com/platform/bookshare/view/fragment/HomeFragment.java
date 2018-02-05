package com.platform.bookshare.view.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.HomePageAdapter;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：${赵若位} on 2017/6/3 23:06
 * 邮箱：1070138445@qq.com
 * 功能：
 */

public class HomeFragment extends BaseFragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<String> tabs = new ArrayList<>();
    private List<Fragment> fragments = new ArrayList<>();

    private HomePageAdapter homePageAdapter;
    private RecycleFragment fragment;

    @Override
    public int getResource() {
        return R.layout.fragment_home;
    }

    @Override
    public void init(View view) {
        AutoUtils.auto(view);
        tabLayout = (TabLayout) view.findViewById(R.id.home_tablayout);
        viewPager = (ViewPager) view.findViewById(R.id.home_viewpage);

        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        fragment = new RecycleFragment();

    }

    @Override
    public void loadingDatas() {
        tabs.add("默认");
        tabs.add("销量");
        tabs.add("价格");
        tabs.add("好评");
        tabs.add("出版时间");

        Bundle bundle = new Bundle();
        for (int i=0;i<5;i++){
            bundle.putInt("index",i);
            fragments.add(RecycleFragment.newInstance(bundle));
        }

//        fragments.add(fragment.setArguments());
//        fragments.add(new RecycleFragment());
//        fragments.add(new RecycleFragment());
//        fragments.add(new RecycleFragment());
//        fragments.add(new RecycleFragment());

        homePageAdapter = new HomePageAdapter(getActivity().getSupportFragmentManager(),getActivity(),fragments,tabs);
        viewPager.setAdapter(homePageAdapter);
        viewPager.addOnPageChangeListener(new HomePageChangeListener());
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void startdestroy() {
    }

    class HomePageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            Bundle bundle = new Bundle();
            bundle.putInt("index",state);
            fragment.setArguments(bundle);
        }
    }
}
