package id.eka_cbn.samplegetpost.helper;

import id.eka_cbn.samplegetpost.model.Product;
import id.eka_cbn.samplegetpost.model.ProductData;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by ekhacahya on 9/5/2016.
 * ekhacahya@live.com
 */

public interface RequestInterface {
    @GET(Constant.GET_PRODUCT)
    Call<Product> getProducts();

    @POST(Constant.POST_PRODUCT)
    Call<Product> postData(@Body ProductData productDat);

    @FormUrlEncoded
    @POST(Constant.POST_PRODUCT)
    Call<Product> postData(
            @Field("name")String name,
            @Field("price")String price,
            @Field("description")String description
    );

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
