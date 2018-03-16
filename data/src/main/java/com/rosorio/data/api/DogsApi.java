package com.rosorio.data.api;

import com.rosorio.data.api.response.DogsApiResponse;
import com.rosorio.data.entity.BreedImage;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */

public interface DogsApi {
    @GET("api/breeds/list")
    Observable<DogsApiResponse<List<String>>> getAllBreeds();

    @GET("api/breed/{breed_name}/images")
    Observable<List<BreedImage>> getImagesByBreed(@Path("breed_name") String breed);
}
