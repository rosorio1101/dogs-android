package com.rosorio.dogs.injection.modules;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public class SchedulersModule {

    @Named("IOScheduler")
    @Provides
    @Singleton
    public Scheduler provideIOScheduler() {
        return Schedulers.io();
    }

    @Named("AndroidScheduler")
    @Provides
    @Singleton
    public Scheduler provideAndroidScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
