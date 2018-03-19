package com.rosorio.dogs.injection.modules;

import com.rosorio.dogs.images.presenter.BreedImagesPresenter;
import com.rosorio.dogs.images.presenter.BreedImagesPresenterImpl;
import com.rosorio.domain.usecase.FindImagesForBreedUseCase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public class ImagesModule {
    @Provides
    public BreedImagesPresenter providePresenter(FindImagesForBreedUseCase useCase,
                                                 @Named("IOScheduler")Scheduler ioScheduler,
                                                 @Named("AndroidScheduler")Scheduler androidScheduler) {
        return new BreedImagesPresenterImpl(useCase, ioScheduler, androidScheduler);
    }
}
