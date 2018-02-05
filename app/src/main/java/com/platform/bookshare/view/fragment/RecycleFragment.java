package com.platform.bookshare.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.RecycleBookShowAdapter;
import com.platform.bookshare.utils.view.MyItemOrition;
import com.platform.bookshare.view.activity.ShopInfoActivity;
import com.platform.bookshare.view.bean.ShopRecycleBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangchen on 2018/1/30.
 */

public class RecycleFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private List<ShopRecycleBean> beans = new ArrayList<>();
    private RecycleBookShowAdapter adapter;

    @Override
    public int getResource() {
        return R.layout.item_recycleview;
    }

    public static RecycleFragment newInstance(Bundle bundle) {
        RecycleFragment fragment = new RecycleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.item_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        MyItemOrition myItemOrition = new MyItemOrition();
        myItemOrition.setColor(getActivity().getResources().getColor(R.color.ECECEC));
        myItemOrition.setHeight(10);
        recyclerView.addItemDecoration(myItemOrition);

        int index = getArguments().getInt("index");
        Log.d("测试",index+"");
    }

    @Override
    public void loadingDatas() {
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,5,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,4,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,3,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,2,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,1,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,0,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,5,"https://img1.doubanio.com/spic/s28888458.jpg"));
        beans.add(new ShopRecycleBean("132","1水浒传","施耐庵","新华书店出版社",28.00,
                21.03,5,"https://img1.doubanio.com/spic/s28888458.jpg"));
        adapter = new RecycleBookShowAdapter(getActivity(),beans);
        recyclerView.setAdapter(adapter);
        adapter.onItemClick(new RecycleBookShowAdapter.OnItemClick() {
            @Override
            public void onViewClick(View view, ShopRecycleBean bean) {
                Log.d("测试",bean.toString());
                Intent it = new Intent(getActivity(), ShopInfoActivity.class);
                startActivity(it);
            }
        });
    }

    @Override
    public void startdestroy() {

    }
}
