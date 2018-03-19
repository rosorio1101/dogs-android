package com.rosorio.domain.usecase;

import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.BreedImagesRepository;
import com.rosorio.domain.mapper.BreedImageToBreedImageModelMapper;
import com.rosorio.domain.mapper.Mapper;
import com.rosorio.domain.model.BreedImageModel;
import com.rosorio.domain.model.BreedModel;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
public class FindImagesForBreedUseCaseTest {
    @Mock
    BreedImagesRepository repository;
    
    Mapper<BreedImage, BreedImageModel> mapper;
    
    FindImagesForBreedUseCase useCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mapper = new BreedImageToBreedImageModelMapper();
        
        useCase = new FindImagesForBreedUseCase(repository, mapper);
    }

    @Test
    public void execute_shouldReturnObservableBreedImagesList_whenSuccess() throws Exception {
        List<BreedImage> breedList = new ArrayList<>();
        breedList.add(new BreedImage("url1"));

        doReturn(Observable.just(breedList)).when(repository).findImagesByBreedName(anyString());

        Observable<List<BreedImageModel>> observable = useCase.execute("name");

        assertNotNull(observable);

        BreedImageModel model = observable.blockingFirst().get(0);

        assertEquals("url1", model.getUrl());
    }
}