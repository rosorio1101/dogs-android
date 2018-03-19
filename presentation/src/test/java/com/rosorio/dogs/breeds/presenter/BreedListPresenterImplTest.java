package com.rosorio.dogs.breeds.presenter;

import com.rosorio.domain.model.BreedModel;
import com.rosorio.domain.usecase.FindAllBreedUseCase;

import org.junit.After;
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

import static org.mockito.ArgumentMatchers.anyListOf;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
public class BreedListPresenterImplTest {
    @Mock
    FindAllBreedUseCase mockUseCase;
    @Mock
    BreedListPresenter.View mockView;

    BreedListPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        Scheduler scheduler = Schedulers.newThread();
        Scheduler scheduler2 = Schedulers.newThread();

        presenter = new BreedListPresenterImpl(mockUseCase, scheduler, scheduler2);
        presenter.onViewAttached(mockView);
    }

    @After
    public void tearDown() throws Exception {
        presenter.onStop();
        presenter.onViewDetached();
        presenter.onDestroy();
    }

    @Test
    public void onStart_shouldShowBreedList_whenSuccess() throws Exception {
        List<BreedModel> breedList = new ArrayList<>();
        breedList.add(new BreedModel("name1"));
        breedList.add(new BreedModel("name2"));

        doReturn(Observable.just(breedList)).when(mockUseCase).execute(null);
        presenter.onStart(true);

        verify(mockView).showBreeds(ArgumentMatchers.<BreedModel>anyList());
    }
}