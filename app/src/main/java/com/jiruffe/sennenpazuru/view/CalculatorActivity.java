package com.jiruffe.sennenpazuru.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;

import com.jiruffe.sennenpazuru.R;
import com.jiruffe.sennenpazuru.databinding.ActivityCalculatorBinding;
import com.jiruffe.sennenpazuru.model.Player;
import com.jiruffe.sennenpazuru.view.base.ActivityBase;


public class CalculatorActivity extends ActivityBase {

    Player p1 = new Player();
    Player p2 = new Player();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_calculator;
    }

    @Override
    protected void doInitArgs(Bundle savedInstanceState) {
        ActivityCalculatorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator);
        binding.setP1(p1);
        binding.setP2(p2);

        binding.p1Area.setOnClickListener((view) -> {
            Log.e("hhh", "111");
            p1.minus(100);
        });

        binding.p2Area.setOnClickListener((view) -> {
            Log.e("hhh", "222");
            p2.minus(200);
        });
    }

    @Override
    protected void doInitView() {
    }

    @Override
    protected void doLoadData() {

    }

}
