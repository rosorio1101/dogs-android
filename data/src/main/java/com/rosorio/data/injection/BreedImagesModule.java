package com.rosorio.data.injection;

import com.rosorio.data.api.DogBreedImagesApi;
import com.rosorio.data.repository.BreedImagesRepository;
import com.rosorio.data.repository.datasource.factory.BreedImagesDataSourceFactory;
import com.rosorio.data.repository.datasource.factory.impl.BreedImagesDataSourceFactoryImpl;
import com.rosorio.data.repository.impl.BreedImagesRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public class BreedImagesModule {
    @Provides
    @Singleton
    public DogBreedImagesApi providesApi(Retrofit retrofit) {
        return retrofit.create(DogBreedImagesApi.class);
    }

    @Provides
    public BreedImagesDataSourceFactory providesFactory(DogBreedImagesApi api) {
        return new BreedImagesDataSourceFactoryImpl(api);
    }

    @Provides
    public BreedImagesRepository provideRepository(BreedImagesDataSourceFactory factory) {
        return new BreedImagesRepositoryImpl(factory);
    }
}
