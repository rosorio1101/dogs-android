package com.rosorio.dogs.injection.component;

import com.rosorio.data.injection.BreedImagesModule;
import com.rosorio.data.injection.BreedModule;
import com.rosorio.data.injection.DataModule;
import com.rosorio.dogs.DogsApp;
import com.rosorio.dogs.injection.modules.BreedsModule;
import com.rosorio.dogs.injection.modules.DogsAppModule;
import com.rosorio.dogs.injection.modules.ImagesModule;
import com.rosorio.dogs.injection.modules.LoadingModule;
import com.rosorio.dogs.injection.modules.SchedulersModule;
import com.rosorio.domain.injection.DomainBreedModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Singleton
@Component(
        modules = {
                AndroidInjectionModule.class,
                DataModule.class,
                SchedulersModule.class,
                DogsAppModule.class,
                DomainBreedModule.class,
                LoadingModule.class,
                BreedModule.class,
                BreedsModule.class,
                BreedImagesModule.class,
                ImagesModule.class
                }
)
public interface DogsAppComponent extends AndroidInjector<DogsApp> {

}
