package com.citiestest.ui.map;


import com.citiestest.SchedulersFacade;
import com.citiestest.data.city.model.City;
import com.citiestest.domain.cities.GetCityUseCase;
import com.citiestest.ui.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;


public class MapViewModel extends BaseViewModel {

    private final SchedulersFacade mSchedulersFacade;

    private final GetCityUseCase mGetCityUseCase;

    private final MutableLiveData<City> mResponse = new MutableLiveData<>();

    @Inject
    MapViewModel(SchedulersFacade schedulersFacade,
                 GetCityUseCase getCityUseCase) {
        mSchedulersFacade = schedulersFacade;
        mGetCityUseCase = getCityUseCase;
    }

    MutableLiveData<City> response() {
        return mResponse;
    }

    void loadCity(int cityId) {
        mCompositeDisposable.add(mGetCityUseCase.run(cityId)
                .subscribeOn(mSchedulersFacade.io())
                .observeOn(mSchedulersFacade.ui())
                .subscribe(
                        city -> {
                            mResponse.postValue(city);
                        },
                        err -> {
                            mResponse.postValue(null);
                        }
                )
        );
    }
}
