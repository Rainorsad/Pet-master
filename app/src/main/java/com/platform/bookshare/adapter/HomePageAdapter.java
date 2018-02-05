package com.platform.bookshare.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Zhangchen on 2018/1/30.
 */

public class HomePageAdapter extends FragmentPagerAdapter{
    private List<Fragment> fragments;
    private List<String> list_titles;
    private Context context;

    public HomePageAdapter(FragmentManager fm, Context context, List<Fragment> listfragments, List<String> list_title) {
        super(fm);
        this.context = context;
        this.fragments = listfragments;
        this.list_titles = list_title;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_titles.get(position);
    }
}
