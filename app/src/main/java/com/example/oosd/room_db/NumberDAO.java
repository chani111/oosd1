package com.example.oosd.room_db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.oosd.model.Number;

import java.util.List;

@Dao
public interface NumberDAO {

    @Query("SELECT * FROM number WHERE phone LIKE :num")
    List<Number> findWithNumber(String num);

    @Query("SELECT * FROM number")
    List<Number> getAllNumber();

    @Insert
    void insertNumber(Number number);

}
