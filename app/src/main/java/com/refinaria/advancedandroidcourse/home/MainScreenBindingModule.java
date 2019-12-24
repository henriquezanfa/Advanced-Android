package com.refinaria.advancedandroidcourse.home;

import com.bluelinelabs.conductor.Controller;
import com.refinaria.advancedandroidcourse.di.ControllerKey;
import com.refinaria.advancedandroidcourse.trending.TrendingReposComponent;
import com.refinaria.advancedandroidcourse.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {
        TrendingReposComponent.class,
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindingTrendingReposInjector(TrendingReposComponent.Builder builder);
}
