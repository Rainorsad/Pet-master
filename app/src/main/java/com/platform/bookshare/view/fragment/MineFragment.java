package com.platform.bookshare.view.fragment;

import android.content.Intent;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.utils.CacheImageView;
import com.platform.bookshare.view.activity.CaptureActivity;

/**
 * 作者：${赵若位} on 2017/6/3 23:06
 * 邮箱：1070138445@qq.com
 * 功能：
 */

public class MineFragment extends BaseFragment
{

    @Override
    public int getResource()
    {
        return R.layout.fragment_mine;
    }

    @Override
    public void init(View view)
    {
        CacheImageView  qr_img = (CacheImageView)view.findViewById(R.id.code_img);
        qr_img = (CacheImageView)view.findViewById(R.id.me_headerImg);
        qr_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MineFragment.this.getActivity(), CaptureActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void loadingDatas()
    {

    }

    @Override
    public void startdestroy()
    {

    }
}
