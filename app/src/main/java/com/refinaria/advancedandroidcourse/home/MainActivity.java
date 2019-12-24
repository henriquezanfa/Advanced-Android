package com.refinaria.advancedandroidcourse.home;

import com.bluelinelabs.conductor.Controller;
import com.refinaria.advancedandroidcourse.R;
import com.refinaria.advancedandroidcourse.base.BaseActivity;
import com.refinaria.advancedandroidcourse.trending.TrendingReposController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}