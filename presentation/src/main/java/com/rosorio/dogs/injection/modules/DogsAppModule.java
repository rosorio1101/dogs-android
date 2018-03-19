package com.rosorio.dogs.injection.modules;

import com.rosorio.dogs.breeds.activity.BreedListActivity;
import com.rosorio.dogs.common.fragment.LoadingFragment;
import com.rosorio.dogs.images.activity.BreedImagesActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public abstract class DogsAppModule {
    @ContributesAndroidInjector
    abstract BreedListActivity contributeBreedListActivityInjector();

    @ContributesAndroidInjector
    abstract BreedImagesActivity contributeBreedImagesActivityInjector();
}
