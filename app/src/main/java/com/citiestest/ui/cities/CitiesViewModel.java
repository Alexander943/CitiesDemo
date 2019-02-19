package com.citiestest.ui.cities;

import com.citiestest.SchedulersFacade;
import com.citiestest.data.city.model.City;
import com.citiestest.domain.usecase.GetCities;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;


public class CitiesViewModel extends ViewModel {

    private final GetCities mGetCities;
    private final SchedulersFacade mSchedulersFacade;

    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    private final MutableLiveData<List<City>> mResponse = new MutableLiveData<>();
    private final MutableLiveData<Boolean> mLoading = new MutableLiveData<>();

    @Inject
    public CitiesViewModel(GetCities getCities, SchedulersFacade schedulersFacade) {
        mGetCities = getCities;
        mSchedulersFacade = schedulersFacade;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.clear();
    }

    MutableLiveData<List<City>> response() {
        return mResponse;
    }

    MutableLiveData<Boolean> loading() {
        return mLoading;
    }

    void loadCities() {
        mCompositeDisposable.add(mGetCities.run(new GetCities.RequestValues())
                .subscribeOn(mSchedulersFacade.io())
                .observeOn(mSchedulersFacade.ui())
                .doOnSubscribe(__ -> mLoading.postValue(true))
                .subscribe(
                        cities -> {
                            mLoading.postValue(false);
                            mResponse.postValue(cities.getCities());
                        },
                        err -> {
                            mLoading.postValue(false);
                            mResponse.postValue(null);
                        }
                )
        );
    }
}
