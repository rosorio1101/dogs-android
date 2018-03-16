package com.rosorio.data.repository.datasource.remote;

import android.os.Build;

import com.rosorio.data.api.DogsApi;
import com.rosorio.data.api.response.DogsApiResponse;
import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.datasource.BreedDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public class BreedRemoteDataSource extends RemoteDataSource<DogsApi> implements BreedDataSource {

    public BreedRemoteDataSource(DogsApi api) {
        super(api);
    }

    @Override
    public Observable<List<Breed>> findAllBreed() {
        return getApi().getAllBreeds().map(new Function<DogsApiResponse<List<String>>, List<Breed>>() {
            @Override
            public List<Breed> apply(DogsApiResponse<List<String>> dogsApiResponse) throws Exception {
                List<Breed> breedList = new ArrayList<>();
                for (String name: dogsApiResponse.getMessage()) {
                    breedList.add(new Breed(name));
                }
                return breedList;
            }
        });
    }
}
