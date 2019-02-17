package com.citiestest.di.module;

import com.citiestest.AppViewModelFactory;
import com.citiestest.di.ViewModelKey;
import com.citiestest.ui.cities.CitiesViewModel;
import com.citiestest.ui.map.MapViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CitiesViewModel.class)
    abstract ViewModel bindCitiesViewModel(CitiesViewModel citiesViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel.class)
    abstract ViewModel bindMapViewModel(MapViewModel mapViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AppViewModelFactory factory);
}
