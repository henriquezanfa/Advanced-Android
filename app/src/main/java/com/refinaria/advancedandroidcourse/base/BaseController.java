package com.refinaria.advancedandroidcourse.base;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.refinaria.advancedandroidcourse.di.Injector;

public abstract class BaseController extends Controller {

    private boolean injected = false;
    @Override
    protected void onContextAvailable(@NonNull Context context) {
        // Controller instance retained across config changes, so this method can be called more than once. This makes
        // sure we don't waste any time injecting more than once
        if(!injected) {
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }
}
