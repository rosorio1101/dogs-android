package com.rosorio.domain.mapper;

import com.rosorio.data.entity.BreedImage;
import com.rosorio.domain.model.BreedImageModel;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImageToBreedImageModelMapper extends AbstractMapper<BreedImage, BreedImageModel> {

    @Override
    public BreedImageModel map(BreedImage input) {
        return new BreedImageModel(input.getUrl());
    }
}
