package com.platform.bookshare.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.platform.bookshare.view.bean.EMMessage;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by Zhangchen on 2018/1/29.
 */

public class ChartListVIewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<EMMessage> list;
    private Context context;

    public ChartListVIewAdapter(Context context, List<EMMessage> list) {
        super();
        this.context = context;
        this.list = list;
    }

    /**
     * 这是一个添加一条数据并刷新界面的方法
     *
     * @param msg
     */
    public void addData(EMMessage msg) {
        list.add(list.size(), msg);
        notifyItemInserted(list.size());
    }

    /**
     * 这是一个根据不同的条目返回不同的类型的布局的方法
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        EMMessage msg = list.get(position);
        if (msg.getType() == EMMessage.RIGHT_TEXT) {
            return EMMessage.RIGHT_TEXT;
        } else if (msg.getType() == EMMessage.RIGHT_IMG) {
            return EMMessage.RIGHT_IMG;
        } else if (msg.getType() == EMMessage.LEFT_TEXT) {
            return EMMessage.LEFT_TEXT;
        } else if (msg.getType() == EMMessage.LEFT_IMG) {
            return EMMessage.LEFT_IMG;
        }

        return super.getItemViewType(position);
    }

    /**
     * 根据不同的类型返回不同的holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == EMMessage.RIGHT_TEXT) {
            //发送者文本
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_righttext, parent, false);
            AutoUtils.auto(view);
            return new RightTextViewHolder(view);
        } else if (viewType == EMMessage.RIGHT_IMG) {
            //发送者图片
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_rightimg, parent, false);
            AutoUtils.auto(view);
            return new RightImgViewHolder(view);
        } else if (viewType == EMMessage.LEFT_TEXT) {
            //接受者文本
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_lefttext, parent, false);
            AutoUtils.auto(view);
            return new LeftTextViewHolder(view);
        } else if (viewType == EMMessage.LEFT_IMG) {
            //接受者图片
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_leftimg, parent, false);
            AutoUtils.auto(view);
            return new LeftImgViewHolder(view);
        }
        return null;
    }

    /**
     * 这是一个绑定数据的方法
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        EMMessage emMessage = list.get(position);
        if (holder instanceof RightTextViewHolder) {
            Glide.with(context).load(R.mipmap.head).centerCrop().into(((RightTextViewHolder) holder).img_head);
            ((RightTextViewHolder) holder).tv_contect.setText(emMessage.getText_context());
        } else if (holder instanceof RightImgViewHolder) {
            if (TextUtils.isEmpty(emMessage.getImg_head())) {
                Glide.with(context).load(R.mipmap.head).centerCrop().into(((RightImgViewHolder) holder).img_head);
            }
            Glide.with(context).load(R.drawable.dongman1).centerCrop().into(((RightImgViewHolder) holder).img_contect);
        } else if (holder instanceof LeftTextViewHolder) {
            Glide.with(context).load(R.mipmap.head).into(((LeftTextViewHolder) holder).img_head);
            ((LeftTextViewHolder) holder).tv_contect.setText(emMessage.getText_context());
        } else if (holder instanceof LeftImgViewHolder) {
            if (TextUtils.isEmpty(emMessage.getImg_head())) {
                Glide.with(context).load(R.mipmap.head).centerCrop().into(((LeftImgViewHolder) holder).img_head);
            }
            Glide.with(context).load(R.drawable.dongman1).centerCrop().into(((LeftImgViewHolder) holder).img_contect);
        }
    }

    /**
     * 条目个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /**
     * 以下四个内部类为定义的不同的holder
     */
    class RightTextViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_contect;
        private ImageView img_head;

        public RightTextViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView) itemView.findViewById(R.id.img_head);
            tv_contect = (TextView) itemView.findViewById(R.id.tv_contect);
        }
    }

    class RightImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_head;
        private ImageView img_contect;

        public RightImgViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView) itemView.findViewById(R.id.img_head);
            img_contect = (ImageView) itemView.findViewById(R.id.img_contect);
        }
    }

    class LeftTextViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_contect;
        private ImageView img_head;

        public LeftTextViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView) itemView.findViewById(R.id.img_head);
            tv_contect = (TextView) itemView.findViewById(R.id.tv_contect);
        }
    }

    class LeftImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_head;
        private ImageView img_contect;

        public LeftImgViewHolder(View itemView) {
            super(itemView);
            img_head = (ImageView) itemView.findViewById(R.id.img_head);
            img_contect = (ImageView) itemView.findViewById(R.id.img_contect);
        }
    }
}
