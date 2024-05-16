package com.example.calculator;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CalculationEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String calculation;
    public double result;

    public CalculationEntity(int id, String calculation, double result) {
        this.id = id;
        this.calculation = calculation;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCalculation() {
        return calculation;
    }

    public void setCalculation(String calculation) {
        this.calculation = calculation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
// constructor, getters and setters
}