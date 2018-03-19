package com.rosorio.data.repository.impl;

import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.BaseRepository;
import com.rosorio.data.repository.BreedRepository;
import com.rosorio.data.repository.datasource.factory.BreedDataSourceFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public class BreedRepositoryImpl extends BaseRepository<BreedDataSourceFactory> implements BreedRepository {

    public BreedRepositoryImpl(BreedDataSourceFactory factory) {
        super(factory);
    }

    @Override
    public Observable<List<Breed>> findAllBreeds() {
        return getFactory().getRemoteDataSource().findAllBreed();
    }
}
