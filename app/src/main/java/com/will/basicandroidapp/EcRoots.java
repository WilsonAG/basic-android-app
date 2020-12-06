package com.will.basicandroidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EcRoots extends AppCompatActivity {

    private TextView eq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec_roots);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.eq = findViewById(R.id.equation);

        findViewById(R.id.lblRoots).setVisibility(View.INVISIBLE);

        this.initActivity();
    }

    private void solveEq(int a, int b, int c) {

        TextView lblRoots = findViewById(R.id.lblRoots),
                sol1 = findViewById(R.id.root1),
                sol2 = findViewById(R.id.root2);

        try {
            double root = Math.pow(b, 2) - (4 * a * c);
            double x1 = -b + Math.sqrt(root);
            double x2 = -b - Math.sqrt(root);

            x1 =  x1 / (2 * a);
            x2 = x2 / (2 * a);

            if (Double.isNaN(x1) || Double.isNaN(x2)){
                this.eq.setText(R.string.no_sol);
                lblRoots.setVisibility(View.INVISIBLE);
                sol1.setVisibility(View.INVISIBLE);
                sol2.setVisibility(View.INVISIBLE);
            }

            DecimalFormat df = new DecimalFormat("#.####");

            sol1.setText(new StringBuilder("X1: ").append(df.format(x1)));
            sol2.setText(new StringBuilder("X2: ").append(df.format(x2)));
        } catch (Exception ex) {
            this.eq.setText(R.string.no_sol);
            lblRoots.setVisibility(View.INVISIBLE);
            sol1.setVisibility(View.INVISIBLE);
            sol2.setVisibility(View.INVISIBLE);
        }


    }

    private void initActivity() {
        int a = getIntent().getIntExtra("a", 0),
                b = getIntent().getIntExtra("b", 0),
                c = getIntent().getIntExtra("c", 0);


        StringBuilder eqText = new StringBuilder();
        eqText.append(a).append("x^2 + ");
        eqText.append(b).append("x + ");
        eqText.append(c);
        this.eq.setText(eqText);

        // Solve equation
        this.solveEq(a, b, c);
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