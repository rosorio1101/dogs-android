package com.rosorio.data.repository.datasource;

import com.rosorio.data.entity.BreedImage;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface BreedImagesDataSource extends DataSource {
    Observable<List<BreedImage>> findImagesByBreedName(String breedName);
}
