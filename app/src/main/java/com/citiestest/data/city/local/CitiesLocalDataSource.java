package com.citiestest.data.city.local;

import android.app.Application;

import com.citiestest.data.city.model.City;

import java.util.List;

import javax.inject.Inject;

import androidx.room.Room;
import io.reactivex.Observable;

public class CitiesLocalDataSource {

    private final CitiesDAO mCitiesDAO;

    @Inject
    CitiesLocalDataSource(Application application) {
        mCitiesDAO = Room.databaseBuilder(application, CitiesDatabase.class, "cities-db")
                .build()
                .citiesDAO();
    }

    public Observable<List<City>> getCities() {
        return mCitiesDAO.getAll()
                .toObservable();
    }

    public Observable<City> getCityById(int cityId) {
        return mCitiesDAO.getById(cityId)
                .toObservable();
    }

    public void insertOrUpdate(List<City> cities) {
        mCitiesDAO.insertOrUpdate(cities);
    }
}
