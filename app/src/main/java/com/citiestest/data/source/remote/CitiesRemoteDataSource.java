package com.citiestest.data.source.remote;

import com.citiestest.data.City;
import com.citiestest.data.network.CitiesApi;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


@Singleton
public class CitiesRemoteDataSource {

    @NonNull
    private final CitiesApi mService;

    @NonNull
    private final Gson mGson;

    @Inject
    public CitiesRemoteDataSource(@NonNull CitiesApi service, @NonNull Gson gson) {
        mService = service;
        mGson = gson;
    }

    public Observable<List<City>> getCities() {
        return mService.getCities()
                .flatMap(response -> {
                    JSONObject object = new JSONObject(response.body().string());
                    JSONArray array = object.getJSONArray("cities");
                    City[] cities = mGson.fromJson(array.toString(), City[].class);
                    return Observable.just(Arrays.asList(cities));
                });
    }
}
