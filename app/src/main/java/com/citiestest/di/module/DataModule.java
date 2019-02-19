package com.citiestest.di.module;

import com.citiestest.data.city.CitiesDataSource;
import com.citiestest.data.city.CitiesRepository;
import com.citiestest.data.city.local.CitiesDAO;
import com.citiestest.data.city.remote.CitiesRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public abstract class DataModule {

    @Singleton
    @Provides
    static CitiesDataSource provideCitiesRepository(CitiesDAO citiesDAO,
                                                    CitiesRemoteDataSource citiesRemoteDataSource) {
        return new CitiesRepository(citiesDAO, citiesRemoteDataSource);
    }

//    @Singleton
//    @Binds
//    abstract CitiesDataSource provideCitiesRepository(CitiesRepository);
}
