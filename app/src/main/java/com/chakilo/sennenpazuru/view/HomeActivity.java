package com.chakilo.sennenpazuru.view;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chakilo.sennenpazuru.R;
import com.chakilo.sennenpazuru.view.base.ActivityBase;

import butterknife.BindView;

public class HomeActivity extends ActivityBase {
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.llTitle)
    LinearLayout llTitle;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.coordinator)
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
//        navView.getViewTreeObserver()
//                .addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
//                    @Override
//                    public boolean onPreDraw() {
//                        BlurBitmapUtil.blur(drawerLayout, navView, 2, 4);
//                        return true;
//                    }
//                });

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
