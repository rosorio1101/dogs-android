package com.rosorio.dogs.breeds.presenter;

import com.rosorio.dogs.common.presenter.Presenter;
import com.rosorio.domain.model.BreedModel;

import java.util.List;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public interface BreedListPresenter extends Presenter<BreedListPresenter.View> {


    interface View extends Presenter.LoadingView, Presenter.ErrorView {
        void showBreeds(List<BreedModel> breedModels);
    }
}
