package com.citiestest.ui.map;


import com.citiestest.SchedulersFacade;
import com.citiestest.data.city.model.City;
import com.citiestest.ui.BaseViewModel;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;


public class MapViewModel extends BaseViewModel {

    private final SchedulersFacade mSchedulersFacade;

    private final MutableLiveData<City> mResponse = new MutableLiveData<>();

    @Inject
    MapViewModel(SchedulersFacade schedulersFacade) {
        mSchedulersFacade = schedulersFacade;
    }

    MutableLiveData<City> response() {
        return mResponse;
    }

    void simpleAction(City city) {
        mResponse.postValue(city);
    }
}
