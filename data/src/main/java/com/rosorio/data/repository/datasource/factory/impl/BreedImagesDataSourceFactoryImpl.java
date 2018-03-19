package com.rosorio.data.repository.datasource.factory.impl;

import com.rosorio.data.api.DogBreedImagesApi;
import com.rosorio.data.repository.datasource.BreedImagesDataSource;
import com.rosorio.data.repository.datasource.factory.BreedImagesDataSourceFactory;
import com.rosorio.data.repository.datasource.remote.BreedImagesRemoteDataSource;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImagesDataSourceFactoryImpl implements BreedImagesDataSourceFactory {

    BreedImagesDataSource remoteDataSource;

    public BreedImagesDataSourceFactoryImpl(DogBreedImagesApi api) {
        remoteDataSource = new BreedImagesRemoteDataSource(api);
    }

    @Override
    public BreedImagesDataSource getRemoteDataSource() {
        return remoteDataSource;
    }
}
