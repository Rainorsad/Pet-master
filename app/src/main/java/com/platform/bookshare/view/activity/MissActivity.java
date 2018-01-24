package com.platform.bookshare.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.platform.bookshare.R;
import com.platform.bookshare.utils.KJHttpUtil;
import com.platform.bookshare.utils.StatusBarUtils;
import com.platform.bookshare.utils.Tools;

import org.kymjs.kjframe.http.HttpCallBack;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MissActivity extends AppCompatActivity {


    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_pass)
    EditText registerPass;
    @BindView(R.id.code_nums)
    TextView codeNums;
    @BindView(R.id.regist_code)
    EditText registCode;
    @BindView(R.id.regist_btn)
    TextView registBtn;
    @BindView(R.id.top_text)
    TextView topText;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setWindowStatusBarColor(this, R.color.colorPet);
        setContentView(R.layout.activity_miss);
        ButterKnife.bind(this);
        context = this;
        topText.setText("修改密码");
    }

    @OnClick({R.id.top_back, R.id.regist_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.top_back:
                finish();
                break;
            case R.id.regist_btn:
                //保存
                finish();
                Toast.makeText(MissActivity.this, "重置密码成功", Toast.LENGTH_LONG).show();
                break;
            case R.id.code_nums:
                //获取验证码
                getCodeNumber();
                break;
            default:
                break;
        }
    }

    /**
     * 获取验证码
     */
    private void getCodeNumber() {
        String phone = registerPhone.getText().toString();
        if (Tools.isMobile(phone)){
            Toast.makeText(context,"请输入正确的手机号码",Toast.LENGTH_LONG).show();
        }else {
            KJHttpUtil.getCodeNumber(context,phone,codeNumberBack);
        }
    }

    HttpCallBack codeNumberBack = new HttpCallBack() {
        @Override
        public void onSuccess(String t) {
            super.onSuccess(t);
        }

        @Override
        public void onFailure(int errorNo, String strMsg) {
            super.onFailure(errorNo, strMsg);
        }
    };
}
