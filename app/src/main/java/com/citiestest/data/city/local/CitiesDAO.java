package com.citiestest.data.city.local;

import com.citiestest.data.city.model.City;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CitiesDAO {

    @Query("SELECT * FROM city")
    Flowable<List<City>> getAll();

    @Query("SELECT * FROM city WHERE cityId = :id")
    Single<City> getById(int id);

    @Insert
    void insert(City city);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(List<City> cities);

    @Update
    void update(City city);

    @Delete
    void delete(City city);
}
