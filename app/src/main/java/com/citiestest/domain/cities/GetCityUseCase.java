package com.citiestest.domain.cities;

import com.citiestest.data.city.CitiesDataSource;
import com.citiestest.data.city.model.City;
import com.citiestest.domain.UseCase;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Observable;

public final class GetCityUseCase extends UseCase<Integer, City> {

    private final CitiesDataSource mCitiesRepository;

    @Inject
    GetCityUseCase(@NonNull CitiesDataSource citiesRepository) {
        mCitiesRepository = citiesRepository;
    }

    @Override
    protected Observable<City> executeUseCase(Integer requestValues) {
        return mCitiesRepository.getCityById(requestValues);
    }
}