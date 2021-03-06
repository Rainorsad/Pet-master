// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AgreeDetialActivity_ViewBinding<T extends AgreeDetialActivity> implements Unbinder {
  protected T target;

  private View view2131231209;

  @UiThread
  public AgreeDetialActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mTopText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'mTopText'", TextView.class);
    target.mAgreeWeb = Utils.findRequiredViewAsType(source, R.id.agree_web, "field 'mAgreeWeb'", WebView.class);
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131231209 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mTopText = null;
    target.mAgreeWeb = null;

    view2131231209.setOnClickListener(null);
    view2131231209 = null;

    this.target = null;
  }
}
