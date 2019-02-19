package com.citiestest.data.city;

import com.citiestest.data.city.local.CitiesDAO;
import com.citiestest.data.city.model.City;
import com.citiestest.data.city.remote.CitiesRemoteDataSource;

import java.util.List;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


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
//        return Observable.just(mCitiesDAO.getAll());
        return mCitiesRemoteDataSource.getCities();
    }
}
