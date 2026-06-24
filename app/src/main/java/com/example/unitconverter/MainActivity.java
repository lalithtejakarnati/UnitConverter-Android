package com.example.unitconverter;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText etValue;
    Spinner spCategory, spFrom, spTo;
    Button btnConvert;
    TextView tvResult;

    String[] categories = {
            "Length",
            "Weight",
            "Temperature",
            "Time",
            "Area",
            "Volume",
            "Speed",
            "Data",
            "Energy",
            "Pressure"
    };

    String[] lengthUnits = {
            "Millimeter",
            "Centimeter",
            "Meter",
            "Kilometer",
            "Inch",
            "Foot",
            "Yard",
            "Mile"
    };

    String[] weightUnits = {
            "Milligram",
            "Gram",
            "Kilogram",
            "Ton",
            "Ounce",
            "Pound"
    };

    String[] tempUnits = {
            "Celsius",
            "Fahrenheit",
            "Kelvin"
    };

    String[] timeUnits = {
            "Second",
            "Minute",
            "Hour",
            "Day",
            "Week",
            "Month",
            "Year"
    };
    String[] areaUnits = {
            "Square Millimeter",
            "Square Centimeter",
            "Square Meter",
            "Square Kilometer",
            "Acre",
            "Hectare"
    };

    String[] volumeUnits = {
            "Milliliter",
            "Liter",
            "Cubic Meter",
            "Gallon"
    };

    String[] speedUnits = {
            "Meter/Second",
            "Kilometer/Hour",
            "Mile/Hour",
            "Knot"
    };

    String[] dataUnits = {
            "Byte",
            "Kilobyte",
            "Megabyte",
            "Gigabyte",
            "Terabyte"
    };

    String[] energyUnits = {
            "Joule",
            "Kilojoule",
            "Calorie",
            "Kilocalorie"
    };

    String[] pressureUnits = {
            "Pascal",
            "Kilopascal",
            "Bar",
            "PSI",
            "Atmosphere"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValue = findViewById(R.id.etValue);
        spCategory = findViewById(R.id.spCategory);
        spFrom = findViewById(R.id.spFrom);
        spTo = findViewById(R.id.spTo);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);

        ArrayAdapter<String> categoryAdapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        categories) {

                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {

                        View view = super.getView(position, convertView, parent);

                        TextView text =
                                view.findViewById(android.R.id.text1);

                        text.setTextColor(Color.WHITE);
                        text.setTextSize(18);

                        return view;
                    }

                    @Override
                    public View getDropDownView(int position,
                                                View convertView,
                                                ViewGroup parent) {

                        View view = super.getDropDownView(
                                position,
                                convertView,
                                parent);

                        TextView text =
                                view.findViewById(android.R.id.text1);

                        text.setTextColor(Color.BLACK);

                        return view;
                    }
                };

        categoryAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spCategory.setAdapter(categoryAdapter);

        loadUnits(lengthUnits);

        spCategory.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        switch (categories[position]) {

                            case "Length":
                                loadUnits(lengthUnits);
                                break;

                            case "Weight":
                                loadUnits(weightUnits);
                                break;

                            case "Temperature":
                                loadUnits(tempUnits);
                                break;

                            case "Time":
                                loadUnits(timeUnits);
                                break;

                            case "Area":
                                loadUnits(areaUnits);
                                break;

                            case "Volume":
                                loadUnits(volumeUnits);
                                break;

                            case "Speed":
                                loadUnits(speedUnits);
                                break;

                            case "Data":
                                loadUnits(dataUnits);
                                break;

                            case "Energy":
                                loadUnits(energyUnits);
                                break;

                            case "Pressure":
                                loadUnits(pressureUnits);
                                break;
                        }
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                    }
                });

        btnConvert.setOnClickListener(v -> {

            String input = etValue.getText().toString().trim();

            if (input.isEmpty()) {
                tvResult.setText("Enter Value");
                return;
            }

            double value = Double.parseDouble(input);

            String category =
                    spCategory.getSelectedItem().toString();

            String from =
                    spFrom.getSelectedItem().toString();

            String to =
                    spTo.getSelectedItem().toString();

                        double result = value;

                        switch (category) {

                            case "Length":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.LENGTH);
                                break;

                            case "Weight":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.WEIGHT);
                                break;

                            case "Time":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.TIME);
                                break;

                            case "Area":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.AREA);
                                break;

                            case "Volume":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.VOLUME);
                                break;

                            case "Speed":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.SPEED);
                                break;

                            case "Data":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.DATA);
                                break;

                            case "Energy":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.ENERGY);
                                break;

                            case "Pressure":
                                result = ConversionUtils.convert(
                                        value, from, to,
                                        ConversionUtils.PRESSURE);
                                break;

                            case "Temperature":
                                result = ConversionUtils.convertTemperature(
                                        value, from, to);
                                break;
                        }
            tvResult.setText(
                    formatNumber(value) + " " + from +
                            "\n↓\n" +
                            formatNumber(result) + " " + to
            );
        });
    }

    private void loadUnits(String[] units) {

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        units) {

                    @Override
                    public View getView(int position,
                                        View convertView,
                                        ViewGroup parent) {

                        View view = super.getView(
                                position,
                                convertView,
                                parent);

                        TextView text =
                                view.findViewById(android.R.id.text1);

                        text.setTextColor(Color.WHITE);
                        text.setTextSize(18);

                        return view;
                    }

                    @Override
                    public View getDropDownView(
                            int position,
                            View convertView,
                            ViewGroup parent) {

                        View view = super.getDropDownView(
                                position,
                                convertView,
                                parent);

                        TextView text =
                                view.findViewById(android.R.id.text1);

                        text.setTextColor(Color.BLACK);

                        return view;
                    }
                };

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        spFrom.setAdapter(adapter);
        spTo.setAdapter(adapter);
    }

    private String formatNumber(double number) {

        DecimalFormat formatter =
                new DecimalFormat("#,###.####");

        if (number == (long) number) {
            return String.format("%,d", (long) number);
        }

        return formatter.format(number);
    }
}