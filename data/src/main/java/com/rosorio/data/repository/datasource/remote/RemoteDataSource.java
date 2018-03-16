package com.rosorio.data.repository.datasource.remote;

import com.rosorio.data.repository.datasource.DataSource;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public abstract class RemoteDataSource<T> implements DataSource {
    private T api;

    public RemoteDataSource(T api) {
        this.api = api;
    }

    public T getApi() {
        return api;
    }
}
