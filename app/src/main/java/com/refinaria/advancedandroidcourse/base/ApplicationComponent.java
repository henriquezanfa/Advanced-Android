package com.refinaria.advancedandroidcourse.base;

import com.refinaria.advancedandroidcourse.data.RepoServiceModule;
import com.refinaria.advancedandroidcourse.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})
public interface ApplicationComponent {
    void inject(App app);
}