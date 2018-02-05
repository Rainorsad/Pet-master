package com.platform.bookshare.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.shop.ShopAdapter_Main;
import com.platform.bookshare.model.shop.ShopModel;
import com.platform.bookshare.view.view.wowsplash.HomeHeadView;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 功能：首页fragment
 */

public class ShoppingFragment extends BaseFragment {

    @BindView(R.id.shop_main)
    RecyclerView mShopMain;

    private Unbinder mUnbinder;

    private ShopAdapter_Main mAdapter;
    private List<ShopModel> mList;

    @Override
    public int getResource() {
        return R.layout.fragment_shopping;
    }

    @Override
    public void init(View view) {
        mUnbinder = ButterKnife.bind(this, view);

        mList = new ArrayList<>();
        mList.add(new ShopModel("主粮零食", R.drawable.shop_parent1, new int[]{R.drawable.shop_child1, R.drawable.shop_child2, R.drawable.shop_child3, R.drawable.shop_child4,
                R.drawable.shop_child5, R.drawable.shop_child6, R.drawable.shop_child7, R.drawable.shop_child8, R.drawable.shop_child9}));

        mList.add(new ShopModel("医疗保健", R.drawable.shop_parent2, new int[]{R.drawable.shop_child10, R.drawable.shop_child11, 0, R.drawable.shop_child12, R.drawable.shop_child13, 0,
                R.drawable.shop_child14, 0, R.drawable.shop_child15}));

        mList.add(new ShopModel("玩具用品", R.drawable.shop_parent3, new int[]{R.drawable.shop_child16, R.drawable.shop_child17, R.drawable.shop_child18, R.drawable.shop_child19,
                R.drawable.shop_child20, R.drawable.shop_child21, R.drawable.shop_child22, R.drawable.shop_child23, R.drawable.shop_child24}));
        mAdapter = new ShopAdapter_Main(getActivity(), mList);
        mShopMain.setLayoutManager(new LinearLayoutManager(getActivity()));
        mShopMain.setAdapter(mAdapter);
        mAdapter.addHeaderView(new HomeHeadView(getActivity()).crreatView());
        initFooter();
    }

    /**
     * 增加尾部视图
     */
    private void initFooter() {
        View footer = LayoutInflater.from(getActivity()).inflate(R.layout.item_shopping_footer, null);
        AutoUtils.autoSize(footer);
        mAdapter.addFooterView(footer);
    }

    @Override
    public void loadingDatas() {

    }

    @Override
    public void startdestroy() {
        mUnbinder.unbind();
        mAdapter = null;
        mList = null;
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
