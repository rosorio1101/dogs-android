package com.rosorio.domain.injection;

import com.rosorio.data.entity.Breed;
import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.BreedImagesRepository;
import com.rosorio.data.repository.BreedRepository;
import com.rosorio.domain.mapper.BreedImageToBreedImageModelMapper;
import com.rosorio.domain.mapper.BreedToBreedModelMapper;
import com.rosorio.domain.mapper.Mapper;
import com.rosorio.domain.model.BreedImageModel;
import com.rosorio.domain.model.BreedModel;
import com.rosorio.domain.usecase.FindAllBreedUseCase;
import com.rosorio.domain.usecase.FindImagesForBreedUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public class DomainBreedModule {

    @Provides
    public Mapper<Breed, BreedModel> provideBreedToBreedModelMapper(){
        return new BreedToBreedModelMapper();
    }

    @Provides
    public Mapper<BreedImage, BreedImageModel> provideBreedImageToBreedImageModelMapper() {
        return new BreedImageToBreedImageModelMapper();
    }

    @Provides
    public FindAllBreedUseCase provideFindAllBreedUseCase(BreedRepository repository, Mapper<Breed, BreedModel> mapper) {
        return new FindAllBreedUseCase(repository, mapper);
    }

    @Provides
    public FindImagesForBreedUseCase providesFindImagesForBreedUseCase(BreedImagesRepository repository, Mapper<BreedImage, BreedImageModel> mapper) {
        return new FindImagesForBreedUseCase(repository, mapper);
    }
}
