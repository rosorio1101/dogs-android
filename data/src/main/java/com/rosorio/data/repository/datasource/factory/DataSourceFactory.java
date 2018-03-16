package com.rosorio.data.repository.datasource.factory;

import com.rosorio.data.repository.datasource.DataSource;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public interface DataSourceFactory<T extends DataSource> {
    T getRemoteDataSource();
}
