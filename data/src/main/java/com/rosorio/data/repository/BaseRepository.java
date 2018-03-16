package com.rosorio.data.repository;

import com.rosorio.data.repository.datasource.factory.DataSourceFactory;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public abstract class BaseRepository<T extends DataSourceFactory> implements Repository {
    private final T factory;

    public BaseRepository(T factory) {
        this.factory = factory;
    }

    public T getFactory() {
        return factory;
    }
}
