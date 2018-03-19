package com.rosorio.data.repository.datasource.remote;

import com.rosorio.data.api.DogBreedApi;
import com.rosorio.data.api.response.AllBreedResponse;
import com.rosorio.data.api.response.DogsApiResponse;
import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.datasource.BreedDataSource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public class BreedRemoteDataSource extends RemoteDataSource<DogBreedApi> implements BreedDataSource {

    public BreedRemoteDataSource(DogBreedApi api) {
        super(api);
    }

    @Override
    public Observable<List<Breed>> findAllBreed() {
        return getApi().getAllBreeds().map(new Function<AllBreedResponse, List<Breed>>() {
            @Override
            public List<Breed> apply(AllBreedResponse dogsApiResponse) throws Exception {
                List<Breed> breedList = new ArrayList<>();
                for (String name: dogsApiResponse.getMessage()) {
                    breedList.add(new Breed(name));
                }
                return breedList;
            }
        });
    }
}
