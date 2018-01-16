// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RegisterActivity_ViewBinding<T extends RegisterActivity> implements Unbinder {
  protected T target;

  private View view2131231009;

  private View view2131231098;

  private View view2131230999;

  private View view2131230998;

  private View view2131231008;

  @UiThread
  public RegisterActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mLinMain = Utils.findRequiredViewAsType(source, R.id.lin_main, "field 'mLinMain'", LinearLayout.class);
    target.mTopText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'mTopText'", TextView.class);
    target.mRegisterPhone = Utils.findRequiredViewAsType(source, R.id.register_phone, "field 'mRegisterPhone'", EditText.class);
    target.mRegisterPass = Utils.findRequiredViewAsType(source, R.id.register_pass, "field 'mRegisterPass'", EditText.class);
    view = Utils.findRequiredView(source, R.id.register_btn, "field 'mRegisterBtn' and method 'onViewClicked'");
    target.mRegisterBtn = Utils.castView(view, R.id.register_btn, "field 'mRegisterBtn'", TextView.class);
    view2131231009 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131231098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_phone, "method 'onViewClicked'");
    view2131230999 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_pass, "method 'onViewClicked'");
    view2131230998 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.register_agree, "method 'onViewClicked'");
    view2131231008 = view;
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

    target.mLinMain = null;
    target.mTopText = null;
    target.mRegisterPhone = null;
    target.mRegisterPass = null;
    target.mRegisterBtn = null;

    view2131231009.setOnClickListener(null);
    view2131231009 = null;
    view2131231098.setOnClickListener(null);
    view2131231098 = null;
    view2131230999.setOnClickListener(null);
    view2131230999 = null;
    view2131230998.setOnClickListener(null);
    view2131230998 = null;
    view2131231008.setOnClickListener(null);
    view2131231008 = null;

    this.target = null;
  }
}
