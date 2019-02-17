package com.citiestest.data.source;

import com.citiestest.data.City;

import java.util.List;

import io.reactivex.Observable;


public interface CitiesDataSource {

    Observable<List<City>> getCities();
}
