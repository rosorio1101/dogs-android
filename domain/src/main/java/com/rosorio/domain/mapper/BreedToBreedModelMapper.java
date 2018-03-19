package com.rosorio.domain.mapper;

import com.rosorio.data.entity.Breed;
import com.rosorio.domain.model.BreedModel;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedToBreedModelMapper extends AbstractMapper<Breed, BreedModel> {
    @Override
    public BreedModel map(Breed input) {
        return new BreedModel(input.getName());
    }
}
