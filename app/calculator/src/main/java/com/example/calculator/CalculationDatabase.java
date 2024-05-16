package com.example.calculator;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CalculationEntity.class}, version = 1)
public abstract class CalculationDatabase extends RoomDatabase {
    public abstract CalculationDao calculationDao();
}