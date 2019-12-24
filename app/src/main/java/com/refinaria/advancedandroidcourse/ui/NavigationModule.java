package com.refinaria.advancedandroidcourse.ui;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {
    @Binds
    abstract ScreenNavigator providesScreenNavigator(DefaultScreenNavigator screenNavigator);
}
