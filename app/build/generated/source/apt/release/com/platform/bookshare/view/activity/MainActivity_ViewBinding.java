// Generated code from Butter Knife. Do not modify!
package com.platform.bookshare.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.platform.bookshare.R;
import com.zhy.autolayout.AutoFrameLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding<T extends MainActivity> implements Unbinder {
  protected T target;

  private View view2131231091;

  private View view2131231092;

  private View view2131231088;

  private View view2131231098;

  private View view2131231093;

  @UiThread
  public MainActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.mMainFragment = Utils.findRequiredViewAsType(source, R.id.main_fragment, "field 'mMainFragment'", AutoFrameLayout.class);
    target.mImgHome = Utils.findRequiredViewAsType(source, R.id.img_home, "field 'mImgHome'", ImageView.class);
    target.mTvHome = Utils.findRequiredViewAsType(source, R.id.tv_home, "field 'mTvHome'", TextView.class);
    target.mImgHouse = Utils.findRequiredViewAsType(source, R.id.img_house, "field 'mImgHouse'", ImageView.class);
    target.mTvHouse = Utils.findRequiredViewAsType(source, R.id.tv_house, "field 'mTvHouse'", TextView.class);
    target.mImgBuy = Utils.findRequiredViewAsType(source, R.id.img_buy, "field 'mImgBuy'", ImageView.class);
    target.mTvBuy = Utils.findRequiredViewAsType(source, R.id.tv_buy, "field 'mTvBuy'", TextView.class);
    target.mImgService = Utils.findRequiredViewAsType(source, R.id.img_service, "field 'mImgService'", ImageView.class);
    target.mTvService = Utils.findRequiredViewAsType(source, R.id.tv_service, "field 'mTvService'", TextView.class);
    target.mImgMine = Utils.findRequiredViewAsType(source, R.id.img_mine, "field 'mImgMine'", ImageView.class);
    target.mTvMine = Utils.findRequiredViewAsType(source, R.id.tv_mine, "field 'mTvMine'", TextView.class);
    view = Utils.findRequiredView(source, R.id.parent_home, "method 'onViewClicked'");
    view2131231091 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_house, "method 'onViewClicked'");
    view2131231092 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_buy, "method 'onViewClicked'");
    view2131231088 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_service, "method 'onViewClicked'");
    view2131231098 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.parent_mine, "method 'onViewClicked'");
    view2131231093 = view;
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

    target.mMainFragment = null;
    target.mImgHome = null;
    target.mTvHome = null;
    target.mImgHouse = null;
    target.mTvHouse = null;
    target.mImgBuy = null;
    target.mTvBuy = null;
    target.mImgService = null;
    target.mTvService = null;
    target.mImgMine = null;
    target.mTvMine = null;

    view2131231091.setOnClickListener(null);
    view2131231091 = null;
    view2131231092.setOnClickListener(null);
    view2131231092 = null;
    view2131231088.setOnClickListener(null);
    view2131231088 = null;
    view2131231098.setOnClickListener(null);
    view2131231098 = null;
    view2131231093.setOnClickListener(null);
    view2131231093 = null;

    this.target = null;
  }
}
