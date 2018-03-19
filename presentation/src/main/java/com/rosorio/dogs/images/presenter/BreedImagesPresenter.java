package com.rosorio.dogs.images.presenter;

import com.rosorio.data.entity.BreedImage;
import com.rosorio.dogs.common.presenter.Presenter;
import com.rosorio.domain.model.BreedImageModel;

import java.util.List;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface BreedImagesPresenter extends Presenter<BreedImagesPresenter.View> {

    void showImages(String breedName);

    interface View extends Presenter.LoadingView, Presenter.ErrorView {
        void showBreedImages(List<BreedImageModel> list);
    }
}
