package com.platform.bookshare.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.FragmentEvaluationAdapter;
import com.platform.bookshare.utils.view.MyItemOrition;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by Zhangchen on 2018/2/5.
 */

public class ShopEvaluationFtagment extends BaseFragment{
    private RecyclerView recycleview;

    @Override
    public int getResource() {
        return R.layout.item_recycleview;
    }

    @Override
    public void init(View view) {
        AutoUtils.auto(view);
        recycleview = (RecyclerView) view.findViewById(R.id.item_recycleview);
        recycleview.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyItemOrition orition = new MyItemOrition();
        orition.setColor(getActivity().getResources().getColor(R.color.gl_background));
        orition.setHeight(1);
        recycleview.addItemDecoration(orition);
    }

    @Override
    public void loadingDatas() {
        recycleview.setAdapter(new FragmentEvaluationAdapter());
    }

    @Override
    public void startdestroy() {

    }
}
