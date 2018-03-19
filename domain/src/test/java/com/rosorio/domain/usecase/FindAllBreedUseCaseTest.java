package com.rosorio.domain.usecase;

import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.BreedRepository;
import com.rosorio.domain.mapper.BreedToBreedModelMapper;
import com.rosorio.domain.mapper.Mapper;
import com.rosorio.domain.model.BreedModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.util.ConnectConsumer;
import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
public class FindAllBreedUseCaseTest {

    @Mock
    BreedRepository breedRepository;

    Mapper<Breed, BreedModel> mapper;

    FindAllBreedUseCase useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mapper = new BreedToBreedModelMapper();

        useCase = new FindAllBreedUseCase(breedRepository, mapper);
    }

    @Test
    public void execute_shouldReturnObservableBreedList_whenSuccess() throws Exception {
        List<Breed> breedList = new ArrayList<>();
        breedList.add(new Breed("breed1"));

        doReturn(Observable.just(breedList)).when(breedRepository).findAllBreeds();

        Observable<List<BreedModel>> observable = useCase.execute(null);

        assertNotNull(observable);

        BreedModel model = observable.blockingFirst().get(0);

        assertEquals("breed1", model.getName());
    }
}