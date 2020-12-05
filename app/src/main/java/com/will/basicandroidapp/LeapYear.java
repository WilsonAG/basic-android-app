package com.will.basicandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LeapYear extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leap_year);

        TextView tvYear = findViewById(R.id.tvLYYear);
        TextView tvDesc = findViewById(R.id.tvLYDesc);

        int year = getIntent().getIntExtra("year", -1);


        tvYear.setText(String.valueOf(year));
        if (this.isLeapYear(year)){
            tvDesc.setText(R.string.leap_year_true);
        } else {
            tvDesc.setText(R.string.leap_year_false);
        }
    }

    private boolean isLeapYear(int year) {
        if (year % 100 == 0) {
            return year % 4 == 0 && year % 400 == 0;
        }

        return year % 4 == 0;
    }
}