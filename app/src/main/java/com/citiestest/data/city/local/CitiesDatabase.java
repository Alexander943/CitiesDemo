package com.citiestest.data.city.local;

import com.citiestest.data.city.model.City;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {City.class}, version = 1)
public abstract class CitiesDatabase extends RoomDatabase {

    public abstract CitiesDAO citiesDAO();
}
