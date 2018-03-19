package com.rosorio.dogs;

import android.app.Activity;
import android.app.Application;

import com.rosorio.dogs.injection.component.DaggerDogsAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public class DogsApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerDogsAppComponent.create().inject(this);
    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }
}
