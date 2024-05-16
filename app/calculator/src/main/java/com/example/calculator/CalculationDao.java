package com.example.calculator;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CalculationDao {
    @Insert
    void insert(CalculationEntity calculationEntity);

    @Query("SELECT * FROM CalculationEntity")
    List<CalculationEntity> getAll();
}
