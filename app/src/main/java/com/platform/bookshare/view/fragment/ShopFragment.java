package com.platform.bookshare.view.fragment;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.platform.bookshare.R;
import com.platform.bookshare.utils.view.MyItemOrition;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangchen on 2018/1/31.
 */

public class ShopFragment extends BaseFragment implements View.OnClickListener {
    private ViewPager viewPager;
//    private LinearLayout lin_view;
//    private ImageView img_point;
    private TextView tvBookName, tvBookIntroduction, tvBookNowPrice, tvBookOldPrice,
            tvBookAuthor, tvBookPrecc, tvBookTypes, tvShopAddress;
    private EditText editSelectNumber;
    private Button brReduce, btAdd;
    private RecyclerView recyShp;
    private List<View> views = new ArrayList<>();

    private int width = 0;//计算轮播图原点之间的距离

    @Override
    public int getResource() {
        return R.layout.fragment_shopinfo;
    }

    @Override
    public void init(View view) {
        AutoUtils.auto(view);
        viewPager = (ViewPager) view.findViewById(R.id.viewpage);
//        lin_view = (LinearLayout) view.findViewById(R.id.lin_view);
//        img_point = (ImageView) view.findViewById(R.id.img_point);
        tvBookName = (TextView) view.findViewById(R.id.tv_bookname);
        tvBookIntroduction = (TextView) view.findViewById(R.id.tv_bookintroduction);
        tvBookNowPrice = (TextView) view.findViewById(R.id.tv_nowprice);
        tvBookOldPrice = (TextView) view.findViewById(R.id.tv_oldprice);
        tvBookAuthor = (TextView) view.findViewById(R.id.tv_author);
        tvBookPrecc = (TextView) view.findViewById(R.id.tv_precc);
        tvBookTypes = (TextView) view.findViewById(R.id.tv_types);
        tvShopAddress = (TextView) view.findViewById(R.id.tv_address);
        editSelectNumber = (EditText) view.findViewById(R.id.edit_bookselectnumber);
        brReduce = (Button) view.findViewById(R.id.but_reduce); brReduce.setOnClickListener(this);
        btAdd = (Button) view.findViewById(R.id.but_add); btAdd.setOnClickListener(this);
        recyShp = (RecyclerView) view.findViewById(R.id.recycle_shop);
        recyShp.setLayoutManager(new GridLayoutManager(getActivity(),2));
        MyItemOrition itemOrition = new MyItemOrition();
        itemOrition.setHeight(20);
        itemOrition.setColor(getActivity().getResources().getColor(R.color.ededed));
    }

    @Override
    public void loadingDatas() {
        editSelectNumber.setText("1");
        setShuff();//轮播图
    }

    /**
     * 轮播图
     */
    private void setShuff() {
        Integer[] imgs = new Integer[]{R.drawable.pd_1, R.drawable.pd_2, R.drawable.pd_3, R.drawable.pd_4, R.drawable.pd_5};
        for (int i = 0; i < imgs.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(params);
            Glide.with(getActivity()).load(imgs[i]).centerCrop().into(imageView);
            views.add(imageView);

//            View point = new View(getActivity());
//            point.setBackgroundResource(R.drawable.shape_point_gray);
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(30,30);
//            if (i>0){
//                layoutParams.leftMargin = 20;
//            }
//            point.setLayoutParams(layoutParams);
//            lin_view.addView(point);
        }
//        lin_view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                lin_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                width = lin_view.getChildAt(1).getLeft() - lin_view.getChildAt(0).getLeft();
//            }
//        });
        viewPager.setAdapter(new MyPageAdapter());
//        viewPager.addOnPageChangeListener(new listener());
        handler.sendEmptyMessageDelayed(1,3000);
    }

    @Override
    public void startdestroy() {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.but_reduce){
            int i = Integer.parseInt(editSelectNumber.getText().toString());
            if (i>1){
                i= i-1;
            }
            editSelectNumber.setText(i+"");
        }else if (v.getId() == R.id.but_add){
            int i = Integer.parseInt(editSelectNumber.getText().toString());
            i++;
            editSelectNumber.setText(i+"");
        }
    }

    /**
     * 轮播图适配器
     */
    class MyPageAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            View view = views.get(position);
            view.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: //按下
                            handler.removeCallbacksAndMessages(null);//删除handler中所有消息和回调
                            break;
                        case MotionEvent.ACTION_UP: //松开
                            handler.sendEmptyMessageDelayed(1, 3000);
                            break;
                        case MotionEvent.ACTION_CANCEL: //滑动
                            handler.sendEmptyMessageDelayed(1, 3000);
                            break;
                    }
                    return true;
                }
            });
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                int i = viewPager.getCurrentItem();
                if (i < 4) {
                    i++;
                } else {
                    i = 0;
                }
                viewPager.setCurrentItem(i);
                handler.sendEmptyMessageDelayed(1, 3000);
            }
        }
    };

//    class listener implements ViewPager.OnPageChangeListener{
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            int len = (int) (positionOffset * width + position * width);
//            RelativeLayout.LayoutParams pa = (RelativeLayout.LayoutParams) img_point.getLayoutParams();
//            pa.leftMargin = len;
//            img_point.setLayoutParams(pa);
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    }
}
