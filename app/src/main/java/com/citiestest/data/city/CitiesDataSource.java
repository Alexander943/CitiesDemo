package com.citiestest.data.city;

import com.citiestest.data.city.model.City;

import java.util.List;

import io.reactivex.Observable;


public interface CitiesDataSource {

    Observable<List<City>> getCities();

    Observable<City> getCity(int cityId);
}
