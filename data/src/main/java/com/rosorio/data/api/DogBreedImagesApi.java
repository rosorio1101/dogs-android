package com.rosorio.data.api;

import com.rosorio.data.api.response.BreedImagesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface DogBreedImagesApi {
    @GET("api/breed/{breed_name}/images")
    Observable<BreedImagesResponse> getBreedImages(@Path("breed_name") String breedName);
}
