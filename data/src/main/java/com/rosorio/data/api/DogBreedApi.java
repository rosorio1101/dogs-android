package com.rosorio.data.api;

import com.rosorio.data.api.response.AllBreedResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface DogBreedApi {
    @GET("api/breeds/list")
    Observable<AllBreedResponse> getAllBreeds();
}
