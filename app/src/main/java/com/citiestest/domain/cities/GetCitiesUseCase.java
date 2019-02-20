package com.citiestest.domain.cities;

import com.citiestest.data.city.CitiesDataSource;
import com.citiestest.data.city.model.City;
import com.citiestest.domain.Empty;
import com.citiestest.domain.UseCase;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


public final class GetCitiesUseCase extends UseCase<Empty, List<City>> {

    private final CitiesDataSource mCitiesRepository;

    @Inject
    GetCitiesUseCase(@NonNull CitiesDataSource citiesRepository) {
        mCitiesRepository = citiesRepository;
    }

    @Override
    protected Observable<List<City>> executeUseCase(Empty requestValues) {
        return mCitiesRepository.getCities();
    }
}
