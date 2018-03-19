package com.rosorio.data.repository.datasource.remote;

import com.rosorio.data.api.DogBreedImagesApi;
import com.rosorio.data.api.response.BreedImagesResponse;
import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.datasource.BreedImagesDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImagesRemoteDataSource extends RemoteDataSource<DogBreedImagesApi> implements BreedImagesDataSource {

    public BreedImagesRemoteDataSource(DogBreedImagesApi api) {
        super(api);
    }

    @Override
    public Observable<List<BreedImage>> findImagesByBreedName(String breedName) {
        return getApi().getBreedImages(breedName).map(new Function<BreedImagesResponse, List<BreedImage>>() {
            @Override
            public List<BreedImage> apply(BreedImagesResponse breedImagesResponse) throws Exception {
                List<BreedImage> breedImages = new ArrayList<>();
                for (String name: breedImagesResponse.getMessage()) {
                    breedImages.add(new BreedImage(name));
                }
                return breedImages;
            }
        });
    }
}
