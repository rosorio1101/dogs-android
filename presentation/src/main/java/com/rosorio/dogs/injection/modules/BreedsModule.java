package com.rosorio.dogs.injection.modules;

import com.rosorio.dogs.breeds.presenter.BreedListPresenter;
import com.rosorio.dogs.breeds.presenter.BreedListPresenterImpl;
import com.rosorio.domain.usecase.FindAllBreedUseCase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
@Module
public class BreedsModule {
    @Provides
    @Singleton
    public BreedListPresenter providesPresenter(FindAllBreedUseCase useCase,
                                                @Named("IOScheduler") Scheduler ioScheduler,
                                                @Named("AndroidScheduler") Scheduler androidScheduler) {
        return new BreedListPresenterImpl(useCase, ioScheduler, androidScheduler);
    }
}
