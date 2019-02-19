package com.citiestest.di.module;

import android.app.Application;

import com.citiestest.data.city.local.CitiesDAO;
import com.citiestest.data.city.local.CitiesDatabase;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RoomModule {

    @Singleton
    @Provides
    static CitiesDAO providesCitiesDAO(Application application) {
        return Room.databaseBuilder(application, CitiesDatabase.class, "cities-db")
                .build()
                .citiesDAO();
    }
}
