package com.will.basicandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MCM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m_c_m);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvDesc = findViewById(R.id.MCM_desc);
        TextView tvnumber = findViewById(R.id.MCM_number);

        int a = getIntent().getIntExtra("a", 0);
        int b = getIntent().getIntExtra("b", 0);
        int c = getIntent().getIntExtra("c", 0);

        StringBuilder replace = new StringBuilder().append(a).append(", ").append(b).append(" y ").append(c);
        String new_desc = tvDesc.getText().toString().replaceFirst("##", replace.toString());
        tvDesc.setText(new_desc);

        int mcd = this.mcd(a, b, c);
        System.out.println(mcd);
        System.out.println(replace);
        tvnumber.setText(String.valueOf(mcd));
    }

    private int mcd(int a, int b, int c) {
        return this.mcd(a, mcd(b, c));
    }

    private int mcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
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