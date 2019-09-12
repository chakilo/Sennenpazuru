package com.jiruffe.sennenpazuru.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.jiruffe.sennenpazuru.R;
import com.jiruffe.sennenpazuru.util.BlurBitmapUtil;
import com.jiruffe.sennenpazuru.view.base.ActivityBase;


public class HomeActivity extends ActivityBase {
    TextView tvTitle;
    Toolbar toolbar;
    NavigationView navView;
    DrawerLayout drawerLayout;
    CoordinatorLayout coordinator;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_home;
    }

    @Override
    protected void doInitArgs(Bundle savedInstanceState) {

    }

    @Override
    protected void doInitView() {
        tvTitle = findViewById(R.id.tvTitle);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.nav_view);
        coordinator = findViewById(R.id.coordinator);

        //透明导航栏
        transparentNavigationBar();

        //添加小汉堡~~~
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //设置小汉堡的颜色~
        toggle.getDrawerArrowDrawable().setColor(0xffffffff);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //动态设置高斯模糊
        navView.getViewTreeObserver()
                .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                    @Override
                    public boolean onPreDraw() {
                        BlurBitmapUtil.blur(coordinator, navView, 2, 4);
                        return true;
                    }
                });

    }

    @Override
    protected void doLoadData() {

    }


    @Override
    public void onBackPressed() {
        //监听返回键点击事件
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
