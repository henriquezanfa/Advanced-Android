package com.refinaria.advancedandroidcourse.di;

import android.app.Activity;
import android.content.Context;

import com.refinaria.advancedandroidcourse.base.App;
import com.refinaria.advancedandroidcourse.base.BaseActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Provider;

import dagger.android.AndroidInjector;

public class ActivityInjector {

    private final Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors;
    private final Map<String, AndroidInjector<? extends Activity>> cache = new HashMap<>();

    @Inject
    ActivityInjector(Map<Class<? extends Activity>, Provider<AndroidInjector.Factory<? extends Activity>>> activityInjectors) {
        this.activityInjectors = activityInjectors;
    }

    void inject(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extends BaseActivity");
        }

        String instanceId = ((BaseActivity) activity).getInstanceId();
        if (cache.containsKey(instanceId)) {
            //noinspection unchecked
            ((AndroidInjector<Activity>) Objects.requireNonNull(cache.get(instanceId))).inject(activity);
            return;
        }

        //noinspection unchecked
        AndroidInjector.Factory<Activity> injectorFactory =
                (AndroidInjector.Factory<Activity>) activityInjectors.get(activity.getClass()).get();
        AndroidInjector<Activity> injector = injectorFactory.create(activity);
        cache.put(instanceId, injector);
        injector.inject(activity);
    }

    void clear(Activity activity) {
        if (!(activity instanceof BaseActivity)) {
            throw new IllegalArgumentException("Activity must extends BaseActivity");
        }

        cache.remove(((BaseActivity) activity).getInstanceId());
    }

    static ActivityInjector get(Context context) {
        return ((App) context.getApplicationContext()).getActivityInjector();
    }
}