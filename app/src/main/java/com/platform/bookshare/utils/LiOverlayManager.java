package com.platform.bookshare.utils;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.Polyline;
import com.platform.bookshare.overlayutil.OverlayManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhangchen on 2018/1/19.
 */

public class LiOverlayManager extends OverlayManager{
    private List<OverlayOptions> overlayOptions = new ArrayList<>();
    /**
     * 通过一个BaiduMap 对象构造
     *
     * @param baiduMap
     */
    public LiOverlayManager(BaiduMap baiduMap) {
        super(baiduMap);
    }

    public void setOverlayOptions(List<OverlayOptions> overlayOptions) {
        this.overlayOptions = overlayOptions;
    }

    @Override
    public List<OverlayOptions> getOverlayOptions() {
        return overlayOptions;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public boolean onPolylineClick(Polyline polyline) {
        return false;
    }
}
