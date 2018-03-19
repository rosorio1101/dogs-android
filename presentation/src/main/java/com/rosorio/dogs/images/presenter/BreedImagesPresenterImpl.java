package com.rosorio.dogs.images.presenter;

import com.rosorio.dogs.common.presenter.BasePresenter;
import com.rosorio.domain.model.BreedImageModel;
import com.rosorio.domain.usecase.FindImagesForBreedUseCase;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedImagesPresenterImpl extends BasePresenter<BreedImagesPresenter.View> implements BreedImagesPresenter {

    private FindImagesForBreedUseCase useCase;
    private Scheduler ioScheduler;
    private Scheduler androidScheduler;

    public BreedImagesPresenterImpl(FindImagesForBreedUseCase useCase, Scheduler ioScheduler, Scheduler androidScheduler) {
        this.useCase = useCase;
        this.ioScheduler = ioScheduler;
        this.androidScheduler = androidScheduler;
    }

    @Override
    public void onStart(boolean firstInit) {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void showImages(String breedName) {
        view.showLoading();
        useCase.execute(breedName)
                .observeOn(androidScheduler)
                .subscribeOn(ioScheduler)
                .subscribe(new Consumer<List<BreedImageModel>>() {
                    @Override
                    public void accept(List<BreedImageModel> breedImageModels) throws Exception {
                        view.hideLoading();
                        view.showBreedImages(breedImageModels);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.hideLoading();
                        view.showError("Algo ha pasado");
                    }
                });
    }
}
