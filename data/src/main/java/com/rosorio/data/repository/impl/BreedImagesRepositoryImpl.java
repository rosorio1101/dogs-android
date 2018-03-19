package com.rosorio.data.repository.impl;

import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.BaseRepository;
import com.rosorio.data.repository.BreedImagesRepository;
import com.rosorio.data.repository.datasource.factory.BreedImagesDataSourceFactory;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImagesRepositoryImpl extends BaseRepository<BreedImagesDataSourceFactory> implements BreedImagesRepository {

    public BreedImagesRepositoryImpl(BreedImagesDataSourceFactory factory) {
        super(factory);
    }

    @Override
    public Observable<List<BreedImage>> findImagesByBreedName(String breedName) {
        return getFactory().getRemoteDataSource().findImagesByBreedName(breedName);
    }
}
