package com.rosorio.data.repository.impl;

import android.support.v4.media.MediaMetadataCompat;

import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.BreedRepository;
import com.rosorio.data.repository.datasource.BreedDataSource;
import com.rosorio.data.repository.datasource.factory.BreedDataSourceFactory;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */
public class BreedRepositoryImplTest {
    private BreedRepository repository;

    @Mock
    BreedDataSourceFactory mockFactory;

    @Mock
    BreedDataSource mockRemoteDataSource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        doReturn(mockRemoteDataSource).when(mockFactory).getRemoteDataSource();

        repository = new BreedRepositoryImpl(mockFactory);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAllBreeds_shouldReturnBreedList_whenSuccess() throws Exception {

        List<Breed> breedList = new ArrayList<>();
        breedList.add(new Breed("test"));

        doReturn(Observable.just(breedList)).when(mockRemoteDataSource).findAllBreed();

        List<Breed> list = repository.findAllBreeds().blockingFirst();
        assertNotNull(list);
    }
}