package com.will.basicandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spExcercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Init the spinner values*/
        this.spExcercises = findViewById(R.id.spEjercicio);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.exOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spExcercises.setAdapter(adapter);
    }
}