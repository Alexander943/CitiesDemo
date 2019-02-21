package com.citiestest.data.city;

import com.citiestest.data.city.local.CitiesLocalDataSource;
import com.citiestest.data.city.model.City;
import com.citiestest.data.city.remote.CitiesRemoteDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


@Singleton
public class CitiesRepository implements CitiesDataSource {

    private final CitiesLocalDataSource mCitiesLocalDataSource;
    private final CitiesRemoteDataSource mCitiesRemoteDataSource;

    @Inject
    CitiesRepository(@NonNull CitiesLocalDataSource citiesLocalDataSource,
                     @NonNull CitiesRemoteDataSource citiesRemoteDataSource) {
        mCitiesLocalDataSource = citiesLocalDataSource;
        mCitiesRemoteDataSource = citiesRemoteDataSource;
    }

    @Override
    public Observable<List<City>> getCities() {
        return mCitiesLocalDataSource.getCities()
                .flatMap((Function<List<City>, ObservableSource<List<City>>>) cities -> {
                    if (cities.isEmpty()) {
                        return mCitiesRemoteDataSource.getCities()
                                .map(citiesCache -> {
                                    mCitiesLocalDataSource.insertOrUpdate(citiesCache);
                                    return citiesCache;
                                });
                    } else {
                        return Observable.just(cities);
                    }
                });
    }

    @Override
    public Observable<City> getCityById(int cityId) {
        return mCitiesLocalDataSource.getCityById(cityId);
    }
}
