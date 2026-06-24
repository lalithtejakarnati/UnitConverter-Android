package com.example.unitconverter;

import java.util.HashMap;
import java.util.Map;

public class ConversionUtils {

    public static final Map<String, Double> LENGTH = new HashMap<>();
    public static final Map<String, Double> WEIGHT = new HashMap<>();
    public static final Map<String, Double> TIME = new HashMap<>();
    public static final Map<String, Double> AREA = new HashMap<>();
    public static final Map<String, Double> VOLUME = new HashMap<>();
    public static final Map<String, Double> SPEED = new HashMap<>();
    public static final Map<String, Double> DATA = new HashMap<>();
    public static final Map<String, Double> ENERGY = new HashMap<>();
    public static final Map<String, Double> PRESSURE = new HashMap<>();

    static {

        // LENGTH (Meter)
        LENGTH.put("Millimeter", 0.001);
        LENGTH.put("Centimeter", 0.01);
        LENGTH.put("Meter", 1.0);
        LENGTH.put("Kilometer", 1000.0);
        LENGTH.put("Inch", 0.0254);
        LENGTH.put("Foot", 0.3048);
        LENGTH.put("Yard", 0.9144);
        LENGTH.put("Mile", 1609.34);

        // WEIGHT (Gram)
        WEIGHT.put("Milligram", 0.001);
        WEIGHT.put("Gram", 1.0);
        WEIGHT.put("Kilogram", 1000.0);
        WEIGHT.put("Ton", 1000000.0);
        WEIGHT.put("Ounce", 28.3495);
        WEIGHT.put("Pound", 453.592);

        // TIME (Second)
        TIME.put("Second", 1.0);
        TIME.put("Minute", 60.0);
        TIME.put("Hour", 3600.0);
        TIME.put("Day", 86400.0);
        TIME.put("Week", 604800.0);
        TIME.put("Month", 2592000.0);
        TIME.put("Year", 31536000.0);

        // AREA (Square Meter)
        AREA.put("Square Millimeter", 0.000001);
        AREA.put("Square Centimeter", 0.0001);
        AREA.put("Square Meter", 1.0);
        AREA.put("Square Kilometer", 1000000.0);
        AREA.put("Acre", 4046.86);
        AREA.put("Hectare", 10000.0);

        // VOLUME (Liter)
        VOLUME.put("Milliliter", 0.001);
        VOLUME.put("Liter", 1.0);
        VOLUME.put("Cubic Meter", 1000.0);
        VOLUME.put("Gallon", 3.78541);

        // SPEED (Meter/Second)
        SPEED.put("Meter/Second", 1.0);
        SPEED.put("Kilometer/Hour", 0.277778);
        SPEED.put("Mile/Hour", 0.44704);
        SPEED.put("Knot", 0.514444);

        // DATA (Byte)
        DATA.put("Byte", 1.0);
        DATA.put("Kilobyte", 1024.0);
        DATA.put("Megabyte", 1048576.0);
        DATA.put("Gigabyte", 1073741824.0);
        DATA.put("Terabyte", 1099511627776.0);

        // ENERGY (Joule)
        ENERGY.put("Joule", 1.0);
        ENERGY.put("Kilojoule", 1000.0);
        ENERGY.put("Calorie", 4.184);
        ENERGY.put("Kilocalorie", 4184.0);

        // PRESSURE (Pascal)
        PRESSURE.put("Pascal", 1.0);
        PRESSURE.put("Kilopascal", 1000.0);
        PRESSURE.put("Bar", 100000.0);
        PRESSURE.put("PSI", 6894.76);
        PRESSURE.put("Atmosphere", 101325.0);
    }

    public static double convert(
            double value,
            String from,
            String to,
            Map<String, Double> map) {

        double base = value * map.get(from);
        return base / map.get(to);
    }

    public static double convertTemperature(
            double value,
            String from,
            String to) {

        double celsius;

        if (from.equals("Celsius")) {
            celsius = value;
        }
        else if (from.equals("Fahrenheit")) {
            celsius = (value - 32) * 5 / 9;
        }
        else {
            celsius = value - 273.15;
        }

        if (to.equals("Celsius")) {
            return celsius;
        }
        else if (to.equals("Fahrenheit")) {
            return (celsius * 9 / 5) + 32;
        }
        else {
            return celsius + 273.15;
        }
    }
}