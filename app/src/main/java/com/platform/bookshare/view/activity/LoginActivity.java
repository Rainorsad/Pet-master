package com.platform.bookshare.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.platform.bookshare.R;
import com.platform.bookshare.utils.StatusBarUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity
{

    @BindView(R.id.top_text)
    TextView mTopText;
    @BindView(R.id.lin_main)
    LinearLayout mLinMain;

    public static LoginActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        instance = this;
        init();
    }

    private void init()
    {
        mTopText.setText("登录");
        mLinMain.setVisibility(View.VISIBLE);
        mLinMain.animate().setDuration(300).scaleX(1).scaleY(1);
    }

    @OnClick({R.id.top_back, R.id.login_miss, R.id.login_btn, R.id.login_more})
    public void onViewClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.top_back:
                mLinMain.animate().setDuration(300).scaleX(0).scaleY(0);
                mLinMain.setVisibility(View.GONE);
                finish();
                break;
            case R.id.login_miss:
                startActivity(new Intent(instance, MissActivity.class));
                break;
            case R.id.login_btn:
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
                break;
            default:
                break;
        }
    }
}
