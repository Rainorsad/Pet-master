package com.platform.bookshare.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.platform.bookshare.R;
import com.platform.bookshare.utils.view.CircleImage;
import com.platform.bookshare.view.activity.PhotoImageViewActivity;

/**
 * 功能：个人中心fragment
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private CircleImage meCirHead;
    private TextView meTvNickName;
    private ImageView meImgBack;
    private LinearLayout meLinMain;

    private Context context;
    private AppCompatActivity appCompatActivity;

    @Override
    public int getResource() {
        context = getActivity();
        appCompatActivity = (AppCompatActivity) context;
        return R.layout.fragment_mine;
    }

    @Override
    public void init(View view) {
        meImgBack = (ImageView) view.findViewById(R.id.fragme_imgback);
        meTvNickName = (TextView) view.findViewById(R.id.fragme_tvnickname);
        meCirHead = (CircleImage) view.findViewById(R.id.fragme_circlehead);
        meLinMain = (LinearLayout) view.findViewById(R.id.fragme_linmain);

        meCirHead.setOnClickListener(this);
    }

    @Override
    public void loadingDatas() {

    }

    @Override
    public void startdestroy() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fragme_circlehead:
                Intent it = new Intent(context, PhotoImageViewActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("img",1);
                it.putExtras(bundle);
                startActivity(it);
                break;
        }
    }

}
