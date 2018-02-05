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

public class VerificationCodeActivity_ViewBinding<T extends VerificationCodeActivity> implements Unbinder {
  protected T target;

  private View view2131230848;

  private View view2131231209;

  private View view2131230846;

  private View view2131231115;

  @UiThread
  public VerificationCodeActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mTopText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'mTopText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.code_nums, "field 'mCodeNums' and method 'onViewClicked'");
    target.mCodeNums = Utils.castView(view, R.id.code_nums, "field 'mCodeNums'", TextView.class);
    view2131230848 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mCodeGetnums = Utils.findRequiredViewAsType(source, R.id.code_getnums, "field 'mCodeGetnums'", EditText.class);
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131231209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.code_btn, "method 'onViewClicked'");
    view2131230846 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.register_agree, "method 'onViewClicked'");
    view2131231115 = view;
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

    target.mTopText = null;
    target.mCodeNums = null;
    target.mCodeGetnums = null;

    view2131230848.setOnClickListener(null);
    view2131230848 = null;
    view2131231209.setOnClickListener(null);
    view2131231209 = null;
    view2131230846.setOnClickListener(null);
    view2131230846 = null;
    view2131231115.setOnClickListener(null);
    view2131231115 = null;

    this.target = null;
  }
}
