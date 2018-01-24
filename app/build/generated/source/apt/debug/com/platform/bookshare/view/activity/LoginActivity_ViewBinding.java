// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  private View view2131230986;

  private View view2131230990;

  private View view2131230987;

  private View view2131230988;

  @UiThread
  public LoginActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.imgExit = Utils.findRequiredViewAsType(source, R.id.img_exit, "field 'imgExit'", ImageView.class);
    target.editPhone = Utils.findRequiredViewAsType(source, R.id.edit_phone, "field 'editPhone'", EditText.class);
    target.editPass = Utils.findRequiredViewAsType(source, R.id.edit_pass, "field 'editPass'", EditText.class);
    view = Utils.findRequiredView(source, R.id.login_but, "field 'loginBut' and method 'onClick'");
    target.loginBut = Utils.castView(view, R.id.login_but, "field 'loginBut'", Button.class);
    view2131230986 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.loginTextusershow = Utils.findRequiredViewAsType(source, R.id.login_textusershow, "field 'loginTextusershow'", TextView.class);
    view = Utils.findRequiredView(source, R.id.login_wechat, "field 'loginWechat' and method 'onClick'");
    target.loginWechat = Utils.castView(view, R.id.login_wechat, "field 'loginWechat'", ImageView.class);
    view2131230990 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.login_qq, "field 'loginQq' and method 'onClick'");
    target.loginQq = Utils.castView(view, R.id.login_qq, "field 'loginQq'", ImageView.class);
    view2131230987 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.login_sina, "field 'loginSina' and method 'onClick'");
    target.loginSina = Utils.castView(view, R.id.login_sina, "field 'loginSina'", ImageView.class);
    view2131230988 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.imgExit = null;
    target.editPhone = null;
    target.editPass = null;
    target.loginBut = null;
    target.loginTextusershow = null;
    target.loginWechat = null;
    target.loginQq = null;
    target.loginSina = null;

    view2131230986.setOnClickListener(null);
    view2131230986 = null;
    view2131230990.setOnClickListener(null);
    view2131230990 = null;
    view2131230987.setOnClickListener(null);
    view2131230987 = null;
    view2131230988.setOnClickListener(null);
    view2131230988 = null;

    this.target = null;
  }
}
