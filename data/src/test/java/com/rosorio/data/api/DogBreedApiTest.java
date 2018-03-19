package com.rosorio.data.api;

import com.rosorio.data.api.response.AllBreedResponse;
import com.rosorio.data.api.response.DogsApiResponse;
import com.rosorio.data.entity.Breed;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.*;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
public class DogBreedApiTest {
    private DogBreedApi api;
    private MockWebServer mockWebServer;

    @Before
    public void setUp() throws Exception {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
        String url = mockWebServer.url("/").toString();

        OkHttpClient client = new OkHttpClient.Builder().build();
        api = new Retrofit.Builder().baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build().create(DogBreedApi.class);

    }

    @After
    public void tearDown() throws Exception {
        mockWebServer.shutdown();
        api = null;
    }

    @Test
    public void getAllBreeds_shouldReturnListBreed_whenSuccess() throws Exception {
        mockWebServer.enqueue(new MockResponse()
                .setResponseCode(200)
                .setBody("{\n" +
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
                        "}")
        );

        AllBreedResponse allBreedResponse = api.getAllBreeds().blockingFirst();

        assertNotNull(allBreedResponse);
        assertEquals(80, allBreedResponse.getMessage().size());


    }
}