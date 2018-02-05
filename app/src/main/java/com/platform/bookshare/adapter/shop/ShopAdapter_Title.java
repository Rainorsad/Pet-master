package com.platform.bookshare.adapter.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.platform.bookshare.model.shop.Pintuan;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zhangchen on 2018/1/26.
 */

public class ShopAdapter_Title extends RecyclerView.Adapter{

    private Context context;
    private List<Pintuan> datas;

    public ShopAdapter_Title(Context context,List<Pintuan> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pintuan,parent,false);
        PinViewHolder adapter = new PinViewHolder(view);
        AutoUtils.autoSize(view);
        return adapter;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PinViewHolder pinViewHolder = (PinViewHolder) holder;

        Glide.with(context).load(datas.get(position).getImageId()).override(400,400).centerCrop().into(pinViewHolder.mItemImg);
        pinViewHolder.mItemDescript.setText(datas.get(position).getDescript());
        pinViewHolder.mItemMutchOne.setText("￥" + datas.get(position).getMutch_one());
        pinViewHolder.mItemMutchTwo.setText("￥" + datas.get(position).getMutch_two());
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size() ;
    }

    class PinViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView mItemImg;
        @BindView(R.id.item_descript)
        TextView mItemDescript;
        @BindView(R.id.item_mutchOne)
        TextView mItemMutchOne;
        @BindView(R.id.item_mutchTwo)
        TextView mItemMutchTwo;
        public PinViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
