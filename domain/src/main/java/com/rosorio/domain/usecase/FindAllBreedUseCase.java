package com.rosorio.domain.usecase;

import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.BreedRepository;
import com.rosorio.domain.mapper.Mapper;
import com.rosorio.domain.model.BreedModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class FindAllBreedUseCase implements UseCase<Observable<List<BreedModel>>, Void> {

    private BreedRepository breedRepository;
    private Mapper<Breed, BreedModel> mapper;

    public FindAllBreedUseCase(BreedRepository breedRepository, Mapper<Breed, BreedModel> mapper) {
        this.breedRepository = breedRepository;
        this.mapper = mapper;
    }

    @Override
    public Observable<List<BreedModel>> execute(Void param) {
        return breedRepository.findAllBreeds().map(new Function<List<Breed>, List<BreedModel>>() {
            @Override
            public List<BreedModel> apply(List<Breed> breeds) throws Exception {
                return mapper.mapAll(breeds);
            }
        });
    }
}
