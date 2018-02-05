package com.platform.bookshare.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.platform.bookshare.R;
import com.platform.bookshare.adapter.ChartListVIewAdapter;
import com.platform.bookshare.view.bean.EMMessage;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zhangchen on 2018/1/27.
 */

public class ChatActivity extends AppCompatActivity {

    @BindView(R.id.chat_recycle)
    RecyclerView chatRecycle;

    private ChartListVIewAdapter adapter;
    private List<EMMessage> lists = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this,R.layout.activity_chat,null);
        AutoUtils.autoSize(view);
        AutoUtils.auto(view);
        setContentView(view);
        ButterKnife.bind(this);

        chatRecycle.setLayoutManager(new LinearLayoutManager(this));

        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.LEFT_TEXT));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.RIGHT_TEXT));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.LEFT_TEXT));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.RIGHT_TEXT));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.LEFT_TEXT));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.RIGHT_IMG));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.LEFT_IMG));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.RIGHT_IMG));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.LEFT_IMG));
        lists.add(new EMMessage("鉴于目前Google官方推荐使用 Android Studio 进行Android项目开发，自 V3.4.2 开始，Bmob Android SDK 可以使用Gradle来进行包依赖管理，如果你使用Android Studio来进行基于BmobSDK的项目开发，有两种方式","","",EMMessage.RIGHT_TEXT));

        adapter = new ChartListVIewAdapter(this,lists);
        chatRecycle.setAdapter(adapter);
        chatRecycle.setScrollingTouchSlop(adapter.getItemCount() - 1);
    }
}
