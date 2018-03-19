package com.rosorio.dogs.breeds.presenter;

import com.rosorio.dogs.common.presenter.BasePresenter;
import com.rosorio.domain.model.BreedModel;
import com.rosorio.domain.usecase.FindAllBreedUseCase;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */

public class BreedListPresenterImpl extends BasePresenter<BreedListPresenter.View> implements BreedListPresenter {

    private FindAllBreedUseCase useCase;
    private Scheduler ioScheduler;
    private Scheduler androidScheduler;

    public BreedListPresenterImpl(FindAllBreedUseCase useCase, Scheduler ioScheduler, Scheduler androidScheduler) {
        this.useCase = useCase;
        this.ioScheduler = ioScheduler;
        this.androidScheduler = androidScheduler;
    }

    @Override
    public void onStart(boolean firstInit) {
         if (firstInit) {
            findAllBreed();
        }
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    private void findAllBreed() {
        view.showLoading();
        useCase.execute(null).observeOn(androidScheduler)
                .subscribeOn(ioScheduler)
                .subscribe(new Consumer<List<BreedModel>>() {
                    @Override
                    public void accept(List<BreedModel> breedModels) throws Exception {
                        view.hideLoading();
                        view.showBreeds(breedModels);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.hideLoading();
                        view.showError("Ha ocurrido un error");
                    }
                });
    }
}
