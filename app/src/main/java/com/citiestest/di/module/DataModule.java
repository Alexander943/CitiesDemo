package com.citiestest.di.module;

import com.citiestest.data.source.CitiesDataSource;
import com.citiestest.data.source.CitiesRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class DataModule {

    @Singleton
    @Binds
    abstract CitiesDataSource provideCitiesRepository(CitiesRepository citiesRepository);
}
