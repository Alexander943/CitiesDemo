package com.citiestest.domain.usecase;

import com.citiestest.data.city.model.City;
import com.citiestest.data.city.CitiesDataSource;
import com.citiestest.domain.UseCase;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.Observable;


public final class GetCities extends UseCase<GetCities.RequestValues, GetCities.ResponseValue> {

    private final CitiesDataSource mCitiesRepository;

    @Inject
    public GetCities(@NonNull CitiesDataSource citiesRepository) {
        mCitiesRepository = citiesRepository;
    }

    @Override
    protected Observable<ResponseValue> executeUseCase(RequestValues requestValues) {
        return mCitiesRepository.getCities()
                .flatMap(cities -> Observable.just(new ResponseValue(cities)));
    }

    public static class RequestValues implements UseCase.RequestValues {
    }

    public static class ResponseValue implements UseCase.ResponseValue {

        private final List<City> mCities;

        public ResponseValue(List<City> cities) {
            mCities = cities;
        }

        public List<City> getCities() {
            return mCities;
        }
    }
}
