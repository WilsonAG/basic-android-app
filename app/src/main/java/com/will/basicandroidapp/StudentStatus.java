package com.will.basicandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class StudentStatus extends AppCompatActivity {

    private TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_status);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.status = findViewById(R.id.tvStatus);

        double grade = getIntent().getDoubleExtra("grade", -1);

        this.evaluateGrade(grade);
    }


    private void evaluateGrade(double grade) {
        if (grade >= 0 && grade <= 10.5){
            this.status.setText(R.string.bad_opt);
        } else if (grade > 10.5 && grade <= 14) {
            this.status.setText(R.string.regular_opt);
        } else if (grade > 14 && grade < 19){
            this.status.setText(R.string.good_opt);
        } else if(grade >= 19 && grade <= 20) {
            this.status.setText(R.string.excellent_opt);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}