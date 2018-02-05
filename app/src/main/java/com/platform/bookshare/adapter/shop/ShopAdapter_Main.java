package com.platform.bookshare.adapter.shop;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.itemorition.HFViewAdapter;
import com.platform.bookshare.R;
import com.platform.bookshare.model.shop.ShopModel;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zhangchen on 2018/1/26.
 */

public class ShopAdapter_Main extends HFViewAdapter{
    private Context context;
    private List<ShopModel> mList;

    public ShopAdapter_Main(Context c, List<ShopModel> s) {
        super(c, s);
        this.context = c;
        this.mList = s;
    }

    @Override
    protected RecyclerView.ViewHolder onCreateViewHolde(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shopping,viewGroup,false);
        MainViewHolder mainViewHolder = new MainViewHolder(view);
        AutoUtils.autoSize(view);
        return mainViewHolder;
    }

    @Override
    protected void onBindViewHolde(RecyclerView.ViewHolder viewHolder, int i) {
        MainViewHolder mainViewHolder = (MainViewHolder) viewHolder;
        mainViewHolder.mItemTitle.setText(mList.get(i).getTitles());
        Glide.with(context).load(mList.get(i).getImage()).override(621, 186).centerCrop().into(mainViewHolder.mItemImages);

        if (i == 0)
        {
            Glide.with(context).load(mList.get(i).getImages()[0]).into(mainViewHolder.mImage1);
            Glide.with(context).load(mList.get(i).getImages()[1]).into(mainViewHolder.mImage2);
            Glide.with(context).load(mList.get(i).getImages()[2]).into(mainViewHolder.mImage3);
            Glide.with(context).load(mList.get(i).getImages()[3]).into(mainViewHolder.mImage4);
            Glide.with(context).load(mList.get(i).getImages()[4]).into(mainViewHolder.mImage5);
            Glide.with(context).load(mList.get(i).getImages()[5]).into(mainViewHolder.mImage6);
            Glide.with(context).load(mList.get(i).getImages()[6]).into(mainViewHolder.mImage7);
            Glide.with(context).load(mList.get(i).getImages()[7]).centerCrop().into(mainViewHolder.mImage8);
            Glide.with(context).load(mList.get(i).getImages()[8]).centerCrop().into(mainViewHolder.mImage9);

        } else if (i == 1)
        {

            Glide.with(context).load(mList.get(i).getImages()[0]).into(mainViewHolder.mImage1);
            Glide.with(context).load(mList.get(i).getImages()[1]).into(mainViewHolder.mImage2);
            Glide.with(context).load(mList.get(i).getImages()[3]).into(mainViewHolder.mImage4);
            Glide.with(context).load(mList.get(i).getImages()[4]).into(mainViewHolder.mImage5);
            Glide.with(context).load(mList.get(i).getImages()[6]).into(mainViewHolder.mImage7);
            Glide.with(context).load(mList.get(i).getImages()[8]).into(mainViewHolder.mImage9);

            mainViewHolder.mImage3.setVisibility(View.GONE);
            mainViewHolder.mImage6.setVisibility(View.GONE);
            mainViewHolder.mImage8.setVisibility(View.GONE);

        } else if (i == 2)
        {
            Glide.with(context).load(mList.get(i).getImages()[0]).override(480,480).centerCrop().into(mainViewHolder.mImage1);
            Glide.with(context).load(mList.get(i).getImages()[1]).override(480,480).centerCrop().into(mainViewHolder.mImage2);
            Glide.with(context).load(mList.get(i).getImages()[2]).override(480,480).centerCrop().into(mainViewHolder.mImage3);
            Glide.with(context).load(mList.get(i).getImages()[3]).into(mainViewHolder.mImage4);
            Glide.with(context).load(mList.get(i).getImages()[4]).into(mainViewHolder.mImage5);
            Glide.with(context).load(mList.get(i).getImages()[5]).into(mainViewHolder.mImage6);
            Glide.with(context).load(mList.get(i).getImages()[6]).into(mainViewHolder.mImage7);
            Glide.with(context).load(mList.get(i).getImages()[7]).into(mainViewHolder.mImage8);
            Glide.with(context).load(mList.get(i).getImages()[8]).into(mainViewHolder.mImage9);
        }
    }

    @Override
    protected int getItemCounts() {
        return mList == null ? 0 : mList.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_title)
        TextView mItemTitle;
        @BindView(R.id.item_images)
        ImageView mItemImages;
        @BindView(R.id.image1)
        ImageView mImage1;
        @BindView(R.id.image2)
        ImageView mImage2;
        @BindView(R.id.image3)
        ImageView mImage3;
        @BindView(R.id.image4)
        ImageView mImage4;
        @BindView(R.id.image5)
        ImageView mImage5;
        @BindView(R.id.image6)
        ImageView mImage6;
        @BindView(R.id.image7)
        ImageView mImage7;
        @BindView(R.id.image8)
        ImageView mImage8;
        @BindView(R.id.image9)
        ImageView mImage9;
        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
