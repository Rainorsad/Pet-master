package com.platform.bookshare.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.platform.bookshare.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.img_exit)
    ImageView imgExit;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_pass)
    EditText editPass;
    @BindView(R.id.login_but)
    Button loginBut;
    @BindView(R.id.login_textusershow)
    TextView loginTextusershow;
    @BindView(R.id.login_wechat)
    ImageView loginWechat;
    @BindView(R.id.login_qq)
    ImageView loginQq;
    @BindView(R.id.login_sina)
    ImageView loginSina;

    private Context context;
    private String phoneNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        context = this;
    }

    @OnClick({R.id.login_but, R.id.login_wechat, R.id.login_qq, R.id.login_sina})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_but:
                //登录
                Intent it = new Intent(context,MainActivity.class);
                startActivity(it);
                finish();
                break;
            //分享
            case R.id.login_wechat:
                break;
            case R.id.login_qq:
                break;
            case R.id.login_sina:
                break;
        }
    }
}
