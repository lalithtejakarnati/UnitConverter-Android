package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etValue;
    Spinner spFrom, spTo;
    Button btnConvert;
    TextView tvResult;

    String[] units = {"cm", "m", "km"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValue = findViewById(R.id.etValue);
        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        units);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spFrom.setAdapter(adapter);
        spTo.setAdapter(adapter);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String input = etValue.getText().toString();

                if(input.isEmpty()) {
                    tvResult.setText("Enter a value");
                    return;
                }

                double value = Double.parseDouble(input);

                String from =
                        spFrom.getSelectedItem().toString();

                String to =
                        spTo.getSelectedItem().toString();

                double result = convert(value, from, to);

                tvResult.setText("Result: " + result);
            }
        });
    }

    private double convert(
            double value,
            String from,
            String to) {

        if(from.equals(to))
            return value;

        if(from.equals("cm") && to.equals("m"))
            return value / 100;

        if(from.equals("m") && to.equals("cm"))
            return value * 100;

        if(from.equals("m") && to.equals("km"))
            return value / 1000;

        if(from.equals("km") && to.equals("m"))
            return value * 1000;

        if(from.equals("cm") && to.equals("km"))
            return value / 100000;

        if(from.equals("km") && to.equals("cm"))
            return value * 100000;

        return value;
    }
}