package com.rosorio.data.repository.impl;

import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.BreedImagesRepository;
import com.rosorio.data.repository.datasource.BreedImagesDataSource;
import com.rosorio.data.repository.datasource.factory.BreedImagesDataSourceFactory;

import org.junit.After;
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
public class BreedImagesRepositoryImplTest {
    private BreedImagesRepository repository;

    @Mock
    BreedImagesDataSourceFactory factory;

    @Mock
    BreedImagesDataSource mockRemoteDataSource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        doReturn(mockRemoteDataSource).when(factory).getRemoteDataSource();

        repository = new BreedImagesRepositoryImpl(factory);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findImagesByBreedName_shouldReturnBreedImageList_whenSuccess() throws Exception {
        List<BreedImage> breedImages = new ArrayList<>();
        breedImages.add(new BreedImage("url"));

        doReturn(Observable.just(breedImages)).when(mockRemoteDataSource).findImagesByBreedName(anyString());

        List<BreedImage> list = repository.findImagesByBreedName("name").blockingFirst();
        assertNotNull(list);
    }
}