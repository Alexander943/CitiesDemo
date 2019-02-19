package com.citiestest.data.city.local;

import com.citiestest.data.city.model.City;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface CitiesDAO {

    @Query("SELECT * FROM city")
    List<City> getAll();

    @Query("SELECT * FROM city WHERE cityId = :id")
    City getById(int id);

    @Insert
    void insert(City city);

    @Update
    void update(City city);

    @Delete
    void delete(City city);
}
