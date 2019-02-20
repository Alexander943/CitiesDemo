package com.citiestest.data.city;

import com.citiestest.data.city.local.CitiesDAO;
import com.citiestest.data.city.model.City;
import com.citiestest.data.city.remote.CitiesRemoteDataSource;

import java.util.List;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;


@Singleton
public class CitiesRepository implements CitiesDataSource {

    private final CitiesDAO mCitiesDAO;
    private final CitiesRemoteDataSource mCitiesRemoteDataSource;

    public CitiesRepository(@NonNull CitiesDAO citiesDAO,
                            @NonNull CitiesRemoteDataSource citiesRemoteDataSource) {
        mCitiesDAO = citiesDAO;
        mCitiesRemoteDataSource = citiesRemoteDataSource;
    }

    @Override
    public Observable<List<City>> getCities() {
        return mCitiesDAO.getAll()
                .toObservable()
                .flatMap((Function<List<City>, ObservableSource<List<City>>>) cities -> {
                    if (cities.isEmpty()) {
                        return mCitiesRemoteDataSource.getCities()
                                .map(citiesCache -> {
                                    mCitiesDAO.insertOrUpdate(citiesCache);
                                    return citiesCache;
                                });
                    } else {
                        return Observable.just(cities);
                    }
                });
    }

    @Override
    public Observable<City> getCity(int cityId) {
        return mCitiesDAO.getById(cityId)
                .toObservable();
    }
}
