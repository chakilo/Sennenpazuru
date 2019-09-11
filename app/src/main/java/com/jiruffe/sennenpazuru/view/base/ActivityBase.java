package com.jiruffe.sennenpazuru.view.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jiruffe.sennenpazuru.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

public abstract class ActivityBase extends AppCompatActivity {

    protected Toolbar toolbar;

    protected ImmersionBar mImmersionBar;

    protected  boolean isWhiteTitle;                //用于判断是否是白色标题  白色标题需要状态栏字体变深色 默认字体白色

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
        try{
            toolbar = findViewById(R.id.toolbar);
        }catch (Exception e){

        }

        if(toolbar != null){
            mImmersionBar = ImmersionBar.with(this).titleBar(toolbar).statusBarDarkFont(isWhiteTitle, 0.2f);
        }else{
            mImmersionBar = ImmersionBar.with(this).statusBarDarkFont(isWhiteTitle);
        }
        //在BaseActivity里初始化

        mImmersionBar.init();

    }

    /**
     * 透明导航栏
     */
    protected void transparentNavigationBar(){
        mImmersionBar.transparentNavigationBar();

        mImmersionBar.init();
    }

    //---------------------------------
    protected abstract int getLayoutResId();

    protected abstract void doInitArgs(Bundle savedInstanceState);

    protected abstract void doInitView();

    protected abstract void doLoadData();
}
