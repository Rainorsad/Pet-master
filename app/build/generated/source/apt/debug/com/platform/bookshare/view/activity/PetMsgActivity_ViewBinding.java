// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PetMsgActivity_ViewBinding<T extends PetMsgActivity> implements Unbinder {
  protected T target;

  private View view2131231173;

  private View view2131231015;

  private View view2131231017;

  @UiThread
  public PetMsgActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mTopText = Utils.findRequiredViewAsType(source, R.id.top_text, "field 'mTopText'", TextView.class);
    view = Utils.findRequiredView(source, R.id.top_back, "method 'onViewClicked'");
    view2131231173 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_long, "method 'onViewClicked'");
    view2131231015 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_save, "method 'onViewClicked'");
    view2131231017 = view;
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

    view2131231173.setOnClickListener(null);
    view2131231173 = null;
    view2131231015.setOnClickListener(null);
    view2131231015 = null;
    view2131231017.setOnClickListener(null);
    view2131231017 = null;

    this.target = null;
  }
}
