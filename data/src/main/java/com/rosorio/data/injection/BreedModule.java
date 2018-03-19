package com.rosorio.data.injection;

import com.rosorio.data.api.DogBreedApi;
import com.rosorio.data.repository.BreedRepository;
import com.rosorio.data.repository.datasource.factory.BreedDataSourceFactory;
import com.rosorio.data.repository.datasource.factory.impl.BreedDataSourceFactoryImpl;
import com.rosorio.data.repository.impl.BreedRepositoryImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by robertoosoriosanhueza on 17-03-18.
 */
@Module
public class BreedModule {
    public BreedModule() { }

    @Provides
    @Singleton
    public DogBreedApi providesApi(Retrofit retrofit) {
        return retrofit.create(DogBreedApi.class);
    }

    @Provides
    public BreedDataSourceFactory providesFactory(DogBreedApi api) {
        return new BreedDataSourceFactoryImpl(api);
    }

    @Provides
    public BreedRepository provideRepository(BreedDataSourceFactory factory) {
        return new BreedRepositoryImpl(factory);
    }

}
