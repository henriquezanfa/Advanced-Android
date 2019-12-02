package com.refinaria.advancedandroidcourse.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.refinaria.advancedandroidcourse.di.Injector;

import java.util.UUID;

import javax.inject.Inject;

public abstract class BaseActivity extends AppCompatActivity {

    private static String INSTANCE_ID_KEY = "instance_id";
    private String instanceId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }

        Injector.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // When passing through Config Changes, we store the ID
        // and retrieve on the next onCreate
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Injector.clearComponent(this);
    }
}
