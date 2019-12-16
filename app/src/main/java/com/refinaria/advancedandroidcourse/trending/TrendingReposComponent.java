package com.refinaria.advancedandroidcourse.trending;

import com.refinaria.advancedandroidcourse.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ScreenScope
@Subcomponent
public interface TrendingReposComponent extends AndroidInjector<TrendingReposController> {
    @Subcomponent.Builder
    abstract class builder extends AndroidInjector.Builder<TrendingReposController>{}
}
