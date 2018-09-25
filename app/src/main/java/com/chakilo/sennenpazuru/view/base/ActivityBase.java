package com.chakilo.sennenpazuru.view.base;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import butterknife.ButterKnife;

public abstract class ActivityBase extends AppCompatActivity {

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutResId() != 0)
            setContentView(getLayoutResId());//把设置布局文件的操作交给继承的子类
        doInitArgs(savedInstanceState);

        immersionInit();

        doInitView();
        doLoadData();
    }

    /**
     * 沉浸式状态栏
     */
    protected void immersionInit(){
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);

    }

    //---------------------------------
    protected abstract int getLayoutResId();

    protected abstract void doInitArgs(Bundle savedInstanceState);

    protected abstract void doInitView();

    protected abstract void doLoadData();
}
