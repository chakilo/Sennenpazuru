package com.jiruffe.sennenpazuru.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.jiruffe.sennenpazuru.R;
import com.jiruffe.sennenpazuru.databinding.ActivityCalculatorBinding;
import com.jiruffe.sennenpazuru.model.Player;
import com.jiruffe.sennenpazuru.view.base.ActivityBase;

import butterknife.BindView;

public class CalculatorActivity extends ActivityBase {

    @BindView(R.id.p1_area)
    LinearLayout p1_area;
    @BindView(R.id.p2_area)
    LinearLayout p2_area;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_calculator);
//    }

    Player p1 = new Player();
    Player p2 = new Player();

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_calculator;
    }

    @Override
    protected void doInitArgs(Bundle savedInstanceState) {

    }

    @Override
    protected void doInitView() {
        p1_area.setOnClickListener((view) -> {
            Log.e("hhh", "111");
            p1.minus(100);
        });
        p2_area.setOnClickListener((view) -> {
            Log.e("hhh", "222");
            p2.minus(200);
        });
    }

    @Override
    protected void doLoadData() {
        ActivityCalculatorBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator);
        binding.setP1(p1);
        binding.setP2(p2);
    }

}
