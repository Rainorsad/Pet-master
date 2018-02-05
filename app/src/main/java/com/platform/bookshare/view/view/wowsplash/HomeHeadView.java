package com.platform.bookshare.view.view.wowsplash;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.shop.ShopAdapter_Title;
import com.platform.bookshare.model.shop.Pintuan;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangchen on 2018/1/26.
 */

public class HomeHeadView {

    private Context context;
    private RecyclerView recyclerView;

    public HomeHeadView(Context context){
        this.context = context;
    }

    public View crreatView(){
        LayoutInflater layout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layout.inflate(R.layout.header_shopping,null);
        headFindViewById(view);
        onHttp();
        headOnClick();
        return view;
    }

    /**
     * 在此处绑定view
     * @param view
     */
    private void headFindViewById(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.header_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setNestedScrollingEnabled(false);
    }

    /**
     * 在此响应点击事件
     */
    private void headOnClick() {
    }

    /**
     * 在此处联网操作
     */
    private void onHttp() {
        List<Pintuan> mList = new ArrayList<>();
        mList.add(new Pintuan(R.drawable.pintuan_one, "【天然健康膳\n食狗粮，提升...", 39.9, 99));
        mList.add(new Pintuan(R.drawable.pintuan_two, "【适合搭配\n各类猫砂使用...", 29, 62));
        mList.add(new Pintuan(R.drawable.pintuan_three, "【温和配方,\n消炎止痒，抗...", 25, 40));
        mList.add(new Pintuan(R.drawable.pintuan_four, "【精致牛肉肉\n粒，美味有营...", 9.9, 35));
        mList.add(new Pintuan(R.drawable.pintuan_five, "【营养护理系\n列零食，美毛...", 19.9, 39));
        mList.add(new Pintuan(R.drawable.pintuan_six, "【买即送罐\n头】贵族鸸鹋...", 59, 125));
        mList.add(new Pintuan(R.drawable.pintuan_seven, "派地奥 盒装乳\n胶犬用玩具 宠...", 15.9, 35));
        mList.add(new Pintuan(R.drawable.pintuan_eight, "【满99送大礼\n包】 大宠爱 体...", 219, 438));
        mList.add(new Pintuan(R.drawable.pintuan_nine, "柏可心 猫薄荷\n猫零食 天然4...", 6.9, 19));
        ShopAdapter_Title  adapter_title = new ShopAdapter_Title(context,mList);
        recyclerView.setAdapter(adapter_title);
    }
}
