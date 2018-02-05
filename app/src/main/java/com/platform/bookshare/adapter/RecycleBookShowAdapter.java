package com.platform.bookshare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.platform.bookshare.view.bean.ShopRecycleBean;

import java.util.List;

/**
 * Created by Zhangchen on 2018/1/30.
 */

public class RecycleBookShowAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    private OnItemClick click;
    private Context context;
    private List<ShopRecycleBean> datas;

    public RecycleBookShowAdapter(Context context, List<ShopRecycleBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bookshow,parent,false);
        MainViewHolder holder = new MainViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainViewHolder maholder = (MainViewHolder) holder;
        ShopRecycleBean bean = datas.get(position);
        maholder.itemView.setTag(bean);
        Glide.with(context).load(bean.getBookimg()).centerCrop().into(maholder.img_book);
        maholder.tv_bookname.setText(bean.getBookname());
        maholder.tv_bookauthor.setText("作者： " + bean.getBookauthor());
        maholder.tv_bookprecc.setText(bean.getBookpress());
        maholder.tv_nowprice.setText("¥ "+bean.getBooknowprice());
        maholder.tv_oldprice.setText("¥ "+bean.getBookoldprice());
        maholder.lin_evaluation.removeAllViews();
        for (int i=0;i<bean.getBookevaluation();i++){
            ImageView img = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25,25);
            params.setMargins(0,0,10,0);
            img.setLayoutParams(params);
            Glide.with(context).load(R.mipmap.evluation_true).into(img);
            maholder.lin_evaluation.addView(img);
        }
        for (int i=0;i < (5-bean.getBookevaluation()); i++){
            ImageView img = new ImageView(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25,25);
            params.setMargins(0,0,10,0);
            img.setLayoutParams(params);
            Glide.with(context).load(R.mipmap.evluation_false).into(img);
            maholder.lin_evaluation.addView(img);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onClick(View v) {
        if (click != null){
            click.onViewClick(v, (ShopRecycleBean) v.getTag());
        }
    }

    class MainViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_book;
        private TextView tv_bookname,tv_bookauthor,tv_bookprecc,tv_nowprice,tv_oldprice;
        private LinearLayout lin_evaluation;
        public MainViewHolder(View itemView) {
            super(itemView);
            img_book = (ImageView) itemView.findViewById(R.id.img_book);
            tv_bookname = (TextView) itemView.findViewById(R.id.tv_bookname);
            tv_bookauthor = (TextView) itemView.findViewById(R.id.tv_author);
            tv_bookprecc = (TextView) itemView.findViewById(R.id.tv_precc);
            tv_nowprice = (TextView) itemView.findViewById(R.id.book_nowprice);
            tv_oldprice = (TextView) itemView.findViewById(R.id.book_oldprice);
            lin_evaluation = (LinearLayout) itemView.findViewById(R.id.lin_evaluation);
        }
    }

    public static interface OnItemClick {
        void onViewClick(View view, ShopRecycleBean bean);
    }

    public void onItemClick(OnItemClick click){
        this.click = click;
    }
}
