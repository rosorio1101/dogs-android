package com.rosorio.dogs.images.presenter;

import com.rosorio.domain.model.BreedImageModel;
import com.rosorio.domain.usecase.FindImagesForBreedUseCase;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
public class BreedImagesPresenterImplTest {
    @Mock
    FindImagesForBreedUseCase useCase;

    @Mock
    BreedImagesPresenter.View mockView;

    BreedImagesPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Scheduler scheduler = Schedulers.newThread();
        Scheduler scheduler2 = Schedulers.newThread();

        presenter = new BreedImagesPresenterImpl(useCase, scheduler, scheduler2);
        presenter.onViewAttached(mockView);
    }

    @Test
    public void getImagesByBreedName_shouldShowBreedImages_whenSuccess() throws Exception {
        List<BreedImageModel> models = new ArrayList<>();
        models.add(new BreedImageModel("url1"));
        models.add(new BreedImageModel("url2"));

        doReturn(Observable.just(models)).when(useCase).execute(anyString());

        presenter.getImagesByBreedName("name");

        verify(mockView).showBreedImages(ArgumentMatchers.<BreedImageModel>anyList());
    }
}