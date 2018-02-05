package com.platform.bookshare.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.platform.bookshare.utils.view.CircleImage;
import com.platform.bookshare.utils.view.MyItemOrition;

/**
 * Created by Zhangchen on 2018/2/5.
 */

public class FragmentEvaluationAdapter extends RecyclerView.Adapter{
    private Context context;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fragmentevaluation,parent,false);
        EvaluationViewHolder holder = new EvaluationViewHolder(view);
        context = parent.getContext();
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final EvaluationViewHolder evaHolder = (EvaluationViewHolder) holder;
        //评分标准
        if (evaHolder.linEvaluation.getChildCount() == 0) {
            for (int i = 0; i < 4; i++) {
                ImageView img = new ImageView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25, 25);
                params.setMargins(0, 0, 10, 0);
                img.setLayoutParams(params);
                Glide.with(context).load(R.mipmap.evluation_true).into(img);
                evaHolder.linEvaluation.addView(img);
            }
            for (int i = 0; i < 1; i++) {
                ImageView img = new ImageView(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(25, 25);
                params.setMargins(0, 0, 10, 0);
                img.setLayoutParams(params);
                Glide.with(context).load(R.mipmap.evluation_false).into(img);
                evaHolder.linEvaluation.addView(img);
            }
        }

        //图片评价
        evaHolder.recyImgs.setVisibility(View.VISIBLE);
        evaHolder.recyImgs.setAdapter(new EvaluationAdapter());

        //顶和踩
        evaHolder.imgPraise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int praise = Integer.parseInt(evaHolder.tvPraise.getText().toString());
                praise++;
                evaHolder.tvPraise.setText(praise+"");
            }
        });

        evaHolder.imgAgainst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int against = Integer.parseInt(evaHolder.tvAgainst.getText().toString());
                against++;
                evaHolder.tvAgainst.setText(against+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class EvaluationViewHolder extends RecyclerView.ViewHolder{

        private CircleImage cirHead;
        private TextView tvUserName,tvContect,tvTime,tvPraise,tvAgainst,tvReplay;
        private ImageView imgPraise,imgAgainst,imgReplay;
        private LinearLayout linEvaluation;
        private RecyclerView recyImgs;
        public EvaluationViewHolder(View itemView) {
            super(itemView);
            cirHead = (CircleImage) itemView.findViewById(R.id.cir_head);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_name);
            tvContect = (TextView) itemView.findViewById(R.id.tv_evlauation);
            tvTime = (TextView) itemView.findViewById(R.id.tv_time);
            tvPraise = (TextView) itemView.findViewById(R.id.tv_praise);
            tvAgainst = (TextView) itemView.findViewById(R.id.tv_against);
            tvReplay = (TextView) itemView.findViewById(R.id.tv_replay);
            imgPraise = (ImageView) itemView.findViewById(R.id.img_praise);
            imgAgainst = (ImageView) itemView.findViewById(R.id.img_against);
            imgReplay = (ImageView) itemView.findViewById(R.id.img_replay);
            linEvaluation = (LinearLayout) itemView.findViewById(R.id.lin_evaluation);
            recyImgs = (RecyclerView) itemView.findViewById(R.id.recy_img);
            recyImgs.setLayoutManager(new GridLayoutManager(context,3));
            MyItemOrition orition = new MyItemOrition(28);
            recyImgs.addItemDecoration(orition);
            recyImgs.setNestedScrollingEnabled(false);
        }
    }

    /**
     * 评论附带的图片显示器
     */
    class EvaluationAdapter extends RecyclerView.Adapter{
        private Context context;

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_evaluation,parent,false);
            RecyclerView.ViewHolder holder = new MyHolder(view);
            context = parent.getContext();
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyHolder myHolder = (MyHolder) holder;
           Glide.with(context).load(R.drawable.dongman1).centerCrop().into(myHolder.img);
        }

        @Override
        public int getItemCount() {
            return 9;
        }

        class MyHolder extends RecyclerView.ViewHolder{

            private ImageView img;

            public MyHolder(View itemView) {
                super(itemView);
                img = (ImageView) itemView.findViewById(R.id.img);
            }
        }
    }
}
