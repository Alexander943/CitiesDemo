package com.citiestest.data.city.remote;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;


public interface CitiesApi {

    @GET("test/")
    Observable<Response<ResponseBody>> getCities();
}
