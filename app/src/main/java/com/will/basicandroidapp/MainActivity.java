package com.will.basicandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText etData;
    private int selectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init Components
        this.etData = findViewById(R.id.etDatos);

        // Init the spinner values
        Spinner spExcercises = findViewById(R.id.spEjercicio);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.exOptions, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spExcercises.setAdapter(adapter);
        spExcercises.setOnItemSelectedListener(this);

        // Add listener to button
        Button compute = findViewById(R.id.btnEval);
        compute.setOnClickListener(this::onClick);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.selectedItem = position;
        TextView text = findViewById(R.id.tvDatos);
        switch (position) {
            case 0:
                text.setText(R.string.lbl1);
                this.etData.setHint("Ej: 15");
                break;
            case 1:
                text.setText(R.string.lbl2);
                this.etData.setHint("Ej: 2;4;8");
                break;
            case 2:
                text.setText(R.string.lbl3);
                this.etData.setHint("Ej: 2020");
                break;
            case 3:
                text.setText(R.string.lbl4);
                this.etData.setHint("Ej: 25/03/1998");
                break;
            case 4:
                text.setText(R.string.lbl5);
                this.etData.setHint("Ej: 10;15;20");
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void onClick(View v) {
        String data = this.etData.getText().toString().trim();
        if (data.equals("")) {
            Toast.makeText(this, "Por favor ingrese los datos.", Toast.LENGTH_LONG).show();
            return;
        }

        Intent nextPage = null;
        switch (selectedItem) {
            case 1:
                nextPage = new Intent(this, EcRoots.class);
                try {
                    String[] values = data.split(";");
                    int a = Integer.parseInt(values[0]),
                            b = Integer.parseInt(values[1]),
                            c = Integer.parseInt(values[2]);
                    if (values.length > 3) {
                        this.showToast("Solo puede ingresar 3 valores.");
                        return;
                    }

                    if (a == 0) {
                        this.showToast("el valor de a debe ser diferente de 0.");
                        return;
                    }

                    nextPage.putExtra("a", a);
                    nextPage.putExtra("b", b);
                    nextPage.putExtra("c", c);
                } catch (Exception ex) {
                    this.showToast("Ingrese los valores en el formato a;b;c");
                    return;
                }
                break;
            case 2:
                nextPage = new Intent(this, LeapYear.class);
                try {
                    int year = Integer.parseInt(data);
                    if (year < 1582 || year > 2500) {
                        this.showToast("El año debe estar entre 1582 y 2500");
                        return;
                    }

                    nextPage.putExtra("year", year);
                } catch (Exception ex) {
                    this.showToast("Por favor ingrese un año válido.");
                }
                break;
            case 3:
                Toast.makeText(this, "el 4", Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(this, "el 5", Toast.LENGTH_LONG).show();
                break;
            case 0:
            default:
                nextPage = new Intent(this, StudentStatus.class);

                try {
                    double grade = Double.parseDouble(data);
                    if (grade < 0 || grade > 20) {
                        this.showToast("La nota debe estar entre el rango de 0 a 20.");
                        return;
                    }
                    nextPage.putExtra("grade", grade);
                } catch (Exception ex) {
                    this.showToast("La nota debe ser un número.");
                    return;
                }

        }

        startActivity(nextPage);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}