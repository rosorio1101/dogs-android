package com.rosorio.data.repository.datasource.factory.impl;

import com.rosorio.data.api.DogsApi;
import com.rosorio.data.repository.datasource.BreedDataSource;
import com.rosorio.data.repository.datasource.factory.BreedDataSourceFactory;
import com.rosorio.data.repository.datasource.remote.BreedRemoteDataSource;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public class BreedDataSourceFactoryImpl implements BreedDataSourceFactory {

    private BreedDataSource remoteDataSource;

    public BreedDataSourceFactoryImpl(DogsApi api) {
        remoteDataSource = new BreedRemoteDataSource(api);
    }

    @Override
    public BreedDataSource getRemoteDataSource() {
        return remoteDataSource;
    }
}
