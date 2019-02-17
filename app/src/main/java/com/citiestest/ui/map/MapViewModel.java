package com.citiestest.ui.map;


import com.citiestest.SchedulersFacade;
import com.citiestest.data.city.model.City;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;


public class MapViewModel extends ViewModel {

    private final SchedulersFacade mSchedulersFacade;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private final MutableLiveData<City> mResponse = new MutableLiveData<>();

    @Inject
    public MapViewModel(SchedulersFacade schedulersFacade) {
        mSchedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
    }

    MutableLiveData<City> response() {
        return mResponse;
    }

    void simpleAction(City city) {
        mResponse.postValue(city);
    }
}
