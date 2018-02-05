// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChatActivity_ViewBinding<T extends ChatActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ChatActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.chatRecycle = Utils.findRequiredViewAsType(source, R.id.chat_recycle, "field 'chatRecycle'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.chatRecycle = null;

    this.target = null;
  }
}
