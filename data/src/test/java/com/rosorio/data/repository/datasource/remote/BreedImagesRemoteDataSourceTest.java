package com.rosorio.data.repository.datasource.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rosorio.data.api.DogBreedImagesApi;
import com.rosorio.data.api.response.BreedImagesResponse;
import com.rosorio.data.entity.BreedImage;
import com.rosorio.data.repository.datasource.BreedImagesDataSource;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import io.reactivex.Observable;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

/**
 * Created by robertoosoriosanhueza on 18-03-18.
 */
public class BreedImagesRemoteDataSourceTest {
    BreedImagesDataSource dataSource;

    @Mock
    DogBreedImagesApi api;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        dataSource = new BreedImagesRemoteDataSource(api);
    }

    @Test
    public void findImagesByBreedName_shouldReturnBreedImageList_whenSuccess() throws Exception {
        Gson gson = new GsonBuilder().create();
        BreedImagesResponse response = gson.fromJson("{\n" +
                "\t\"status\": \"success\",\n" +
                "\t\"message\": [\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10024.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10038.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10081.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10169.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10215.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10469.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10476.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10493.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10575.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10614.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10640.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10872.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_10895.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1097.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1105.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1180.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_124.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1398.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1591.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1627.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1739.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1815.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1849.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1927.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_1948.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2005.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2020.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_204.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2083.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2139.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_219.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2192.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2327.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2329.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_233.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2344.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2435.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_246.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2482.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2503.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2514.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2515.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2557.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2599.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2600.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2614.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2675.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2757.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2770.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2802.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_288.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_291.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2942.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_2988.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3024.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_308.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3160.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_328.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3365.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3422.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3589.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3635.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3692.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3720.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_3819.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_385.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4019.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4098.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4102.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4115.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4138.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_431.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4323.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4335.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4367.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4382.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4461.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4508.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4641.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4720.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4732.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4734.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4742.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4758.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4796.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4834.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_4991.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_500.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5068.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5241.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5312.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5338.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5519.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5635.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5661.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5683.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5697.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5932.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5936.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5953.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5956.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_5993.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6038.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6044.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_607.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6076.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6092.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6117.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6283.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6297.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6330.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_634.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6563.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_662.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6746.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6748.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6754.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_678.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6790.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_6813.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_684.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7008.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7026.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7060.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7105.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7122.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7170.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7340.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7506.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7537.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7578.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7580.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7590.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7601.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7657.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7753.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_7988.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8037.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_806.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8095.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8226.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8341.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8403.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8489.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_849.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8512.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8579.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8653.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8662.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8669.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8696.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8719.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8734.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8738.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8749.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_8945.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9164.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9232.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9282.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9333.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9603.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9748.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9762.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9769.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9798.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9818.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9829.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9844.jpg\",\n" +
                "\t\t\"https:\\/\\/dog.ceo\\/api\\/img\\/african\\/n02116738_9924.jpg\"\n" +
                "\t]\n" +
                "}",BreedImagesResponse.class);


        doReturn(Observable.just(response)).when(api).getBreedImages(anyString());

        List<BreedImage> list = dataSource.findImagesByBreedName("name").blockingFirst();
        assertNotNull(list);
    }
}