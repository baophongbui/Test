package com.example.calculator;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class History extends AppCompatActivity {
    private TextView historyTextView;
    private CalculationDatabase db;
    private CalculationDao calculationDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        historyTextView = findViewById(R.id.historyTextView);

        db = Room.databaseBuilder(getApplicationContext(),
                CalculationDatabase.class, "calculation_database").build();
        calculationDao = db.calculationDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<CalculationEntity> calculations = calculationDao.getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (CalculationEntity calculation : calculations) {
                            historyTextView.setText(calculation.calculation + " = " + calculation.result + "\n");
                        }
                    }
                });
            }
        }).start();
    }
}