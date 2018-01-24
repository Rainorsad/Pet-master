package com.platform.bookshare.view.fragment;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.platform.bookshare.R;
import com.platform.bookshare.utils.LiOverlayManager;
import com.platform.bookshare.utils.view.CircleImage;
import com.platform.bookshare.utils.view.MyItemOrition;
import com.platform.bookshare.view.activity.LoginActivity;
import com.platform.bookshare.view.adapter.MapListAdapter;
import com.platform.bookshare.view.bean.ShareUserBean;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SENSOR_SERVICE;

/**
 * 功能：分享fragment
 */

public class ServiceFragment extends BaseFragment implements SensorEventListener, View.OnClickListener {

    private static final String TAG = "ServiceFragment";
    LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    private SensorManager mSensorManager;
    private Double lastX = 0.0;
    private int mCurrentDirection = 0;

    private MapListAdapter mapAdapter;
    private Context context;
    private LiOverlayManager manager;
    private MapView mMapView;
    private BaiduMap mBaiduMap;
    private EditText edit_search;
    private ImageView img_search;
    private ImageView img_maplist;
    private PopupWindow popupWindow;
    private RelativeLayout rela_maplistMain;
    private RecyclerView recycle;
    private ImageView img_maplistclose;
    // UI相关
    boolean isFirstLoc = true; // 是否首次定位
    private MyLocationData locData;

    @Override
    public int getResource() {
        context = getActivity();
        return R.layout.fragment_map;
    }

    @Override
    public void init(View view) {

        edit_search = (EditText) view.findViewById(R.id.edit_search);
        img_search = (ImageView) view.findViewById(R.id.img_search);
        img_maplist = (ImageView) view.findViewById(R.id.image_list);
        recycle = (RecyclerView) view.findViewById(R.id.recycleview);
        mMapView = (MapView) view.findViewById(R.id.bmapView);
        rela_maplistMain = (RelativeLayout) view.findViewById(R.id.rela_maplist);
        img_maplistclose = (ImageView) view.findViewById(R.id.img_maplisecolse);

        img_search.setOnClickListener(this);
        img_maplist.setOnClickListener(this);
        img_maplistclose.setOnClickListener(this);

        //recycleview初始化
        recycle.setLayoutManager(new LinearLayoutManager(context));
        MyItemOrition orition = new MyItemOrition();
        orition.setHeight(20);
        orition.setColor(0XFFF5F5F5);
        recycle.addItemDecoration(orition);

        baidumap();
    }

    /**
     * 百度地图初始化信息
     */
    private void baidumap() {
        mSensorManager = (SensorManager) this.getActivity().getSystemService(SENSOR_SERVICE);

        mMapView.showScaleControl(false);
        mMapView.showZoomControls(false);
        mBaiduMap = mMapView.getMap();
        //开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        mBaiduMap.setOnMarkerClickListener(markListener);
        //定位初始化
        mLocClient = new LocationClient(this.getContext());
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setCoorType("bd09ll");

        option.setScanSpan(1000);
        mLocClient.setLocOption(option);
        mLocClient.start();
    }


    @Override
    public void loadingDatas() {
        System.out.println("loadingDatas");
    }

    @Override
    public void startdestroy() {
        mBaiduMap.clear();
        mMapView.onDestroy();
    }

    @Override
    public void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mMapView.onResume();
        super.onResume();
        //为系统的方向传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onStop() {
        //取消注册传感器监听
        mSensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    public void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_search:
                search();
                break;
            case R.id.image_list:
                mapList();
                break;
            case R.id.img_maplisecolse:
                rela_maplistMain.animate().scaleY(0).scaleX(0).setDuration(300);
                rela_maplistMain.setVisibility(View.GONE);
                break;
        }
    }

    /**
     * 显示用户列表
     */
    private void mapList() {
        rela_maplistMain.setVisibility(View.VISIBLE);
        rela_maplistMain.animate().setInterpolator(new MyTimInputer()).scaleX(1).scaleY(1).setDuration(500);
     }

    /**
     * 查找逻辑
     */
    private void search() {
        mBaiduMap.clear();
        LatLng latLng = new LatLng(39.885932, 116.241918);
        Bundle bu1 = new Bundle();
        LatLng lattwo = new LatLng(39.947246, 116.414977);
        Bundle bu2 = new Bundle();
        ShareUserBean shareUserBean1 = new ShareUserBean("123456", "39.885932", "116.241918", "福尔摩斯探案集");
        ShareUserBean shareUserBean2 = new ShareUserBean("987654", "39.947246", "116.414977", "三国演义");
        bu1.putSerializable("data", shareUserBean1);
        bu2.putSerializable("data", shareUserBean2);
        List<OverlayOptions> options = new ArrayList<>();
        options.add(new MarkerOptions()
                .position(latLng)
                .extraInfo(bu1)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.mark))
        );
        options.add(new MarkerOptions()
                .position(lattwo)
                .extraInfo(bu2)
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.mark)));
        manager = new LiOverlayManager(mBaiduMap);
        manager.setOverlayOptions(options);
        mBaiduMap.setOnMarkerClickListener(manager);
        manager.addToMap();
        manager.zoomToSpan();
    }

    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }

            locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                MapStatus.Builder builder = new MapStatus.Builder();
                builder.target(ll).zoom(18.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));
            }
        }
    }

    /**
     * mark点击监听
     */
    BaiduMap.OnMarkerClickListener markListener = new BaiduMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            ShareUserBean bean = (ShareUserBean) marker.getExtraInfo().get("data");
            showPopuWindow(bean);
            return false;
        }
    };

    /**
     * popuwindow显示
     * @param bean
     */
    private void showPopuWindow(ShareUserBean bean) {
        LatLng lattwo = new LatLng(Double.parseDouble(bean.getJingdu()), Double.parseDouble(bean.getWeidu()));
        updateMapState(lattwo);
        //弹出用户分享框

        View view = LayoutInflater.from(context).inflate(R.layout.popup_searchlayout, null);
        RelativeLayout rela_main = (RelativeLayout) view.findViewById(R.id.rela_main);
        TextView user_name = (TextView) view.findViewById(R.id.tv_username);
        TextView user_phone = (TextView) view.findViewById(R.id.tv_userphone);
        CircleImage cir_head = (CircleImage) view.findViewById(R.id.cir_head);
        ImageView img_book = (ImageView) view.findViewById(R.id.img_book);
        TextView tv_book = (TextView) view.findViewById(R.id.tv_bookname);

        if (popupWindow != null){
            popupWindow.dismiss();
        }
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, -150);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                popupWindow.dismiss();
            }
        });
        rela_main.animate().setInterpolator(new MyTimInputer()).scaleX(1).scaleY(1).setDuration(800);

        rela_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, LoginActivity.class);
                startActivity(it);
            }
        });
    }

    /**
     * 动画插值器
     */
    public class MyTimInputer implements TimeInterpolator {
        @Override
        public float getInterpolation(float input) {
            if (input <= 2 / 5f) {
                return 25 / 4f * input * input;
            } else if (input <= 4 / 5f) {
                return 1 / 2f + 25 / 2f * (input - 3 / 5f) * (input - 3 / 5f);
            } else {
                return 3 / 4f + 25 * (input - 9 / 10f) * (input - 9 / 10f);
            }
        }
    }

    /**
     * 更新地图状态显示面板
     */
    private void updateMapState(LatLng latLng) {
        MapStatus mMapstatus = new MapStatus.Builder()
                .target(latLng)
                .zoom(14)
                .build();
        MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapstatus);
        mBaiduMap.animateMapStatus(mapStatusUpdate);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (popupWindow != null){
            popupWindow.dismiss();
        }
    }
}
