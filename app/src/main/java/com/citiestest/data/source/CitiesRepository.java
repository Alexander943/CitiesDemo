package com.citiestest.data.source;

import com.citiestest.data.City;
import com.citiestest.data.source.local.CitiesLocalDataSource;
import com.citiestest.data.source.remote.CitiesRemoteDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


@Singleton
public class CitiesRepository implements CitiesDataSource {

    private final CitiesLocalDataSource citiesLocalDataSource;
    private final CitiesRemoteDataSource citiesRemoteDataSource;

    @Inject
    public CitiesRepository(@NonNull CitiesLocalDataSource citiesLocalDataSource,
                            @NonNull CitiesRemoteDataSource citiesRemoteDataSource) {
        this.citiesLocalDataSource = citiesLocalDataSource;
        this.citiesRemoteDataSource = citiesRemoteDataSource;
    }

    // TODO: 03/07/2018 Add caching to local storage
    @Override
    public Observable<List<City>> getCities() {
        return citiesRemoteDataSource.getCities();
    }
}
