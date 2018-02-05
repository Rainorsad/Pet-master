// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MissActivity_ViewBinding<T extends MissActivity> implements Unbinder {
  protected T target;

  private View view2131231113;

  private View view2131231209;

  @UiThread
  public MissActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.registerPhone = Utils.findRequiredViewAsType(source, R.id.register_phone, "field 'registerPhone'", EditText.class);
    target.registerPass = Utils.findRequiredViewAsType(source, R.id.register_pass, "field 'registerPass'", EditText.class);
    target.codeNums = Utils.findRequiredViewAsType(source, R.id.code_nums, "field 'codeNums'", TextView.class);
    target.registCode = Utils.findRequiredViewAsType(source, R.id.regist_code, "field 'registCode'", EditText.class);
    view = Utils.findRequiredView(source, R.id.regist_btn, "field 'registBtn' and method 'onViewClicked'");
    target.registBtn = Utils.castView(view, R.id.regist_btn, "field 'registBtn'", TextView.class);
    view2131231113 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.topText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'topText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131231209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.registerPhone = null;
    target.registerPass = null;
    target.codeNums = null;
    target.registCode = null;
    target.registBtn = null;
    target.topText = null;

    view2131231113.setOnClickListener(null);
    view2131231113 = null;
    view2131231209.setOnClickListener(null);
    view2131231209 = null;

    this.target = null;
  }
}
