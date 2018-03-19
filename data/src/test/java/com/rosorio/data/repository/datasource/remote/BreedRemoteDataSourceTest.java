package com.rosorio.data.repository.datasource.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rosorio.data.api.DogBreedApi;
import com.rosorio.data.api.response.AllBreedResponse;
import com.rosorio.data.api.response.DogsApiResponse;
import com.rosorio.data.entity.Breed;
import com.rosorio.data.repository.datasource.BreedDataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by robertoosoriosanhueza on 16-03-18.
 */
public class BreedRemoteDataSourceTest {

    BreedDataSource dataSource;

    @Mock
    DogBreedApi api;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dataSource = new BreedRemoteDataSource(api);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAllBreed_shouldReturnBreedList_WhenSuccess() throws Exception {
        Gson gson = new GsonBuilder().create();
        AllBreedResponse response = gson.fromJson("{\n" +
                "\t\"status\": \"success\",\n" +
                "\t\"message\": [\n" +
                "\t\t\"affenpinscher\",\n" +
                "\t\t\"african\",\n" +
                "\t\t\"airedale\",\n" +
                "\t\t\"akita\",\n" +
                "\t\t\"appenzeller\",\n" +
                "\t\t\"basenji\",\n" +
                "\t\t\"beagle\",\n" +
                "\t\t\"bluetick\",\n" +
                "\t\t\"borzoi\",\n" +
                "\t\t\"bouvier\",\n" +
                "\t\t\"boxer\",\n" +
                "\t\t\"brabancon\",\n" +
                "\t\t\"briard\",\n" +
                "\t\t\"bulldog\",\n" +
                "\t\t\"bullterrier\",\n" +
                "\t\t\"cairn\",\n" +
                "\t\t\"chihuahua\",\n" +
                "\t\t\"chow\",\n" +
                "\t\t\"clumber\",\n" +
                "\t\t\"collie\",\n" +
                "\t\t\"coonhound\",\n" +
                "\t\t\"corgi\",\n" +
                "\t\t\"dachshund\",\n" +
                "\t\t\"dane\",\n" +
                "\t\t\"deerhound\",\n" +
                "\t\t\"dhole\",\n" +
                "\t\t\"dingo\",\n" +
                "\t\t\"doberman\",\n" +
                "\t\t\"elkhound\",\n" +
                "\t\t\"entlebucher\",\n" +
                "\t\t\"eskimo\",\n" +
                "\t\t\"germanshepherd\",\n" +
                "\t\t\"greyhound\",\n" +
                "\t\t\"groenendael\",\n" +
                "\t\t\"hound\",\n" +
                "\t\t\"husky\",\n" +
                "\t\t\"keeshond\",\n" +
                "\t\t\"kelpie\",\n" +
                "\t\t\"komondor\",\n" +
                "\t\t\"kuvasz\",\n" +
                "\t\t\"labrador\",\n" +
                "\t\t\"leonberg\",\n" +
                "\t\t\"lhasa\",\n" +
                "\t\t\"malamute\",\n" +
                "\t\t\"malinois\",\n" +
                "\t\t\"maltese\",\n" +
                "\t\t\"mastiff\",\n" +
                "\t\t\"mexicanhairless\",\n" +
                "\t\t\"mountain\",\n" +
                "\t\t\"newfoundland\",\n" +
                "\t\t\"otterhound\",\n" +
                "\t\t\"papillon\",\n" +
                "\t\t\"pekinese\",\n" +
                "\t\t\"pembroke\",\n" +
                "\t\t\"pinscher\",\n" +
                "\t\t\"pointer\",\n" +
                "\t\t\"pomeranian\",\n" +
                "\t\t\"poodle\",\n" +
                "\t\t\"pug\",\n" +
                "\t\t\"pyrenees\",\n" +
                "\t\t\"redbone\",\n" +
                "\t\t\"retriever\",\n" +
                "\t\t\"ridgeback\",\n" +
                "\t\t\"rottweiler\",\n" +
                "\t\t\"saluki\",\n" +
                "\t\t\"samoyed\",\n" +
                "\t\t\"schipperke\",\n" +
                "\t\t\"schnauzer\",\n" +
                "\t\t\"setter\",\n" +
                "\t\t\"sheepdog\",\n" +
                "\t\t\"shiba\",\n" +
                "\t\t\"shihtzu\",\n" +
                "\t\t\"spaniel\",\n" +
                "\t\t\"springer\",\n" +
                "\t\t\"stbernard\",\n" +
                "\t\t\"terrier\",\n" +
                "\t\t\"vizsla\",\n" +
                "\t\t\"weimaraner\",\n" +
                "\t\t\"whippet\",\n" +
                "\t\t\"wolfhound\"\n" +
                "\t]\n" +
                "}", AllBreedResponse.class);

        when(api.getAllBreeds()).thenReturn(Observable.just(response));

        List<Breed> list = dataSource.findAllBreed().blockingFirst();
        assertNotNull(list);
        assertEquals(80, list.size());
    }
}