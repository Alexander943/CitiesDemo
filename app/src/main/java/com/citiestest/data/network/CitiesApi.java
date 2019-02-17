package com.citiestest.data.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;


public interface CitiesApi {

    String BASE_URL = "";

    @GET("test/")
    Observable<Response<ResponseBody>> getCities();
}
