package com.will.basicandroidapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class MyExcatAge extends AppCompatActivity {

    private TextView years;
    private TextView months;
    private TextView days;
    private TextView hours;
    private TextView minutes;
    private TextView seconds;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_excat_age);

        TextView date = findViewById(R.id.mae_date);

        this.years = findViewById(R.id.mae_years);
        this.months = findViewById(R.id.mae_months);
        this.days = findViewById(R.id.mae_days);
        this.hours = findViewById(R.id.mae_hours);
        this.minutes = findViewById(R.id.mae_mins);
        this.seconds = findViewById(R.id.mae_secs);

        String myDate = getIntent().getStringExtra("date");
        date.setText(myDate);

        this.showAge(myDate);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showAge(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate born = LocalDate.parse(date, dtf);
        LocalDateTime now = LocalDateTime.now();

        long years = born.until(now, ChronoUnit.YEARS);
        long months = born.until(now, ChronoUnit.MONTHS);
        long days = born.until(now, ChronoUnit.DAYS);
        long hours = days * 24;
        long mins = hours * 60;
        long secs = mins * 60;

        this.years.setText(new StringBuilder("Años: ").append(years));
        this.months.setText(new StringBuilder("Meses: ").append(months));
        this.days.setText(new StringBuilder("Días: ").append(days));
        this.hours.setText(new StringBuilder("Horas: ").append(hours));
        this.minutes.setText(new StringBuilder("Minutos: ").append(mins));
        this.seconds.setText(new StringBuilder("Segundos: ").append(secs));
    }
}