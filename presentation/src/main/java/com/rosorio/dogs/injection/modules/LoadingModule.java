package com.rosorio.dogs.injection.modules;

import com.rosorio.dogs.common.fragment.LoadingFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public class LoadingModule {
    @Provides
    @Singleton
    public LoadingFragment providesLoadingFragment(){
        return new LoadingFragment();
    }
}
