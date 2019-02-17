package com.citiestest.di.module;

import com.citiestest.ui.cities.CitiesFragment;
import com.citiestest.ui.map.MapFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract CitiesFragment contributeCitiesFragment();

    @ContributesAndroidInjector
    abstract MapFragment contributeMapFragment();
}
