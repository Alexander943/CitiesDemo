package com.citiestest.di.module;

import com.citiestest.data.city.CitiesDataSource;
import com.citiestest.data.city.CitiesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class DataModule {

    @Singleton
    @Binds
    abstract CitiesDataSource provideCitiesRepository(CitiesRepository citiesRepository);
}
