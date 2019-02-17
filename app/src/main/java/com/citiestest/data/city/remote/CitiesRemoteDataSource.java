package com.citiestest.data.city.remote;

import android.app.Application;
import android.content.Context;

import com.citiestest.data.city.model.City;
import com.citiestest.util.FileUtils;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


@Singleton
public class CitiesRemoteDataSource {

    private final Context mContext;
    private final CitiesApi mService;
    private final Gson mGson;

    @Inject
    public CitiesRemoteDataSource(@NonNull Application application,
                                  @NonNull CitiesApi service,
                                  @NonNull Gson gson) {
        mContext = application.getApplicationContext();
        mService = service;
        mGson = gson;
    }

    public Observable<List<City>> getCities() {
        return Observable.just(FileUtils.loadJSONFromAsset(mContext, "cities.json"))
                .delay(2, TimeUnit.SECONDS)
                .flatMap(response -> {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("cities");
                    City[] cities = mGson.fromJson(array.toString(), City[].class);
                    return Observable.just(Arrays.asList(cities));
                });
//        return mService.getCities()
//                .flatMap(response -> {
//                    JSONObject object = new JSONObject(response.body().string());
//                    JSONArray array = object.getJSONArray("cities");
//                    City[] cities = mGson.fromJson(array.toString(), City[].class);
//                    return Observable.just(Arrays.asList(cities));
//                });
    }
}
