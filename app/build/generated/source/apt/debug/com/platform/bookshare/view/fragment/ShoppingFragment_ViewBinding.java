// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShoppingFragment_ViewBinding<T extends ShoppingFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ShoppingFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.mShopMain = Utils.findRequiredViewAsType(source, R.id.shop_main, "field 'mShopMain'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mShopMain = null;

    this.target = null;
  }
}
