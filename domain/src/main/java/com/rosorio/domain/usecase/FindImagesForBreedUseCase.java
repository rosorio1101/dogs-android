package com.rosorio.domain.usecase;

import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.BreedImagesRepository;
import com.rosorio.domain.mapper.Mapper;
import com.rosorio.domain.model.BreedImageModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class FindImagesForBreedUseCase implements UseCase<Observable<List<BreedImageModel>>, String> {

    private BreedImagesRepository repository;
    private Mapper<BreedImage, BreedImageModel> mapper;

    public FindImagesForBreedUseCase(BreedImagesRepository repository, Mapper<BreedImage, BreedImageModel> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<BreedImageModel>> execute(String param) {
        return repository
                .findImagesByBreedName(param)
                .map(new Function<List<BreedImage>, List<BreedImageModel>>() {
                         @Override
                         public List<BreedImageModel> apply(List<BreedImage> list) throws Exception {
                             return mapper.mapAll(list);
                         }
                     }
                );
    }
}
