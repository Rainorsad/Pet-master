// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MsgFragment_ViewBinding<T extends MsgFragment> implements Unbinder {
  protected T target;

  private View view2131231024;

  private View view2131231025;

  private View view2131231026;

  private View view2131231027;

  private View view2131231028;

  private View view2131231029;

  @UiThread
  public MsgFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mMsgViewPager = Utils.findRequiredViewAsType(source, R.id.msg_ViewPager, "field 'mMsgViewPager'", ViewPager.class);
    target.mMsgLine1 = Utils.findRequiredViewAsType(source, R.id.msg_line1, "field 'mMsgLine1'", TextView.class);
    target.mMsgLine2 = Utils.findRequiredViewAsType(source, R.id.msg_line2, "field 'mMsgLine2'", TextView.class);
    target.mMsgLine3 = Utils.findRequiredViewAsType(source, R.id.msg_line3, "field 'mMsgLine3'", TextView.class);
    target.mMsgLine4 = Utils.findRequiredViewAsType(source, R.id.msg_line4, "field 'mMsgLine4'", TextView.class);
    target.mMsgLine5 = Utils.findRequiredViewAsType(source, R.id.msg_line5, "field 'mMsgLine5'", TextView.class);
    target.mMsgLine6 = Utils.findRequiredViewAsType(source, R.id.msg_line6, "field 'mMsgLine6'", TextView.class);
    target.mMsgText1 = Utils.findRequiredViewAsType(source, R.id.msg_text1, "field 'mMsgText1'", TextView.class);
    target.mMsgText2 = Utils.findRequiredViewAsType(source, R.id.msg_text2, "field 'mMsgText2'", TextView.class);
    target.mMsgText3 = Utils.findRequiredViewAsType(source, R.id.msg_text3, "field 'mMsgText3'", TextView.class);
    target.mMsgText4 = Utils.findRequiredViewAsType(source, R.id.msg_text4, "field 'mMsgText4'", TextView.class);
    target.mMsgText5 = Utils.findRequiredViewAsType(source, R.id.msg_text5, "field 'mMsgText5'", TextView.class);
    target.mMsgText6 = Utils.findRequiredViewAsType(source, R.id.msg_text6, "field 'mMsgText6'", TextView.class);
    view = Utils.findRequiredView(source, R.id.msg_title1, "method 'onViewClicked'");
    view2131231024 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_title2, "method 'onViewClicked'");
    view2131231025 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_title3, "method 'onViewClicked'");
    view2131231026 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_title4, "method 'onViewClicked'");
    view2131231027 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_title5, "method 'onViewClicked'");
    view2131231028 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.msg_title6, "method 'onViewClicked'");
    view2131231029 = view;
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

    target.mMsgViewPager = null;
    target.mMsgLine1 = null;
    target.mMsgLine2 = null;
    target.mMsgLine3 = null;
    target.mMsgLine4 = null;
    target.mMsgLine5 = null;
    target.mMsgLine6 = null;
    target.mMsgText1 = null;
    target.mMsgText2 = null;
    target.mMsgText3 = null;
    target.mMsgText4 = null;
    target.mMsgText5 = null;
    target.mMsgText6 = null;

    view2131231024.setOnClickListener(null);
    view2131231024 = null;
    view2131231025.setOnClickListener(null);
    view2131231025 = null;
    view2131231026.setOnClickListener(null);
    view2131231026 = null;
    view2131231027.setOnClickListener(null);
    view2131231027 = null;
    view2131231028.setOnClickListener(null);
    view2131231028 = null;
    view2131231029.setOnClickListener(null);
    view2131231029 = null;

    this.target = null;
  }
}
