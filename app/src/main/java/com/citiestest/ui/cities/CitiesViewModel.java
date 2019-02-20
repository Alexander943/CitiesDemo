package com.citiestest.ui.cities;

import com.citiestest.SchedulersFacade;
import com.citiestest.data.city.model.City;
import com.citiestest.domain.Empty;
import com.citiestest.domain.cities.GetCities;
import com.citiestest.ui.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;


public class CitiesViewModel extends BaseViewModel {

    private final GetCities mGetCities;
    private final SchedulersFacade mSchedulersFacade;

    private final MutableLiveData<List<City>> mResponse = new MutableLiveData<>();
    private final MutableLiveData<Boolean> mLoading = new MutableLiveData<>();

    @Inject
    CitiesViewModel(GetCities getCities, SchedulersFacade schedulersFacade) {
        mGetCities = getCities;
        mSchedulersFacade = schedulersFacade;
    }

    MutableLiveData<List<City>> response() {
        return mResponse;
    }

    MutableLiveData<Boolean> loading() {
        return mLoading;
    }

    void loadCities() {
        mCompositeDisposable.add(mGetCities.run(new Empty())
                .subscribeOn(mSchedulersFacade.io())
                .observeOn(mSchedulersFacade.ui())
                .doOnSubscribe(__ -> mLoading.postValue(true))
                .subscribe(
                        cities -> {
                            mLoading.postValue(false);
                            mResponse.postValue(cities);
                        },
                        err -> {
                            mLoading.postValue(false);
                            mResponse.postValue(null);
                        }
                )
        );
    }
}
