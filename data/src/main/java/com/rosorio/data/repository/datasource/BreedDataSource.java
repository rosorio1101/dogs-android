package com.rosorio.data.repository.datasource;

import com.rosorio.data.entity.Breed;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public interface BreedDataSource extends DataSource {
    Observable<List<Breed>> findAllBreed();
}
