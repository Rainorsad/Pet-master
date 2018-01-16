// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ServiceFragment_ViewBinding<T extends ServiceFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ServiceFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.tex_title = Utils.findRequiredViewAsType(source, R.id.textView, "field 'tex_title'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.tex_title = null;

    this.target = null;
  }
}
