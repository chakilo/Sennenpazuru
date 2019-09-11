package com.jiruffe.sennenpazuru.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

public class Player extends BaseObservable {

    private int lp;

    public Player() {
        this(8000);
    }

    public Player(int lp) {
        this.lp = lp;
    }

    @Bindable
    public String getLp() {
        return String.valueOf(lp);
    }

    public void setLp(int lp) {
        this.lp = lp;
        notifyPropertyChanged(BR._all);
    }

    private void makeSureLpNotLessThanZero() {
        if (lp < 0) {
            lp = 0;
        }

        // 刷新数据显示
        notifyPropertyChanged(BR._all);
    }

    public void minus(int diff) {
        lp -= diff;
        makeSureLpNotLessThanZero();
    }

    public void plus(int diff) {
        lp += diff;
        makeSureLpNotLessThanZero();
    }

    public void multiply(int diff) {
        lp *= diff;
        makeSureLpNotLessThanZero();
    }

    public void divide(int diff) {
        lp /= diff;
        makeSureLpNotLessThanZero();
    }

}
