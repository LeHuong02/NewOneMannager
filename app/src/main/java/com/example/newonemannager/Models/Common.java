package com.example.newonemannager.Models;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class Common {
    public static String baseUrl = "https://newone-ag7.conveyor.cloud/";
    public static Food food;
    public static List<Food> foodList;

    public static String formatMoney(int money) {
        Locale locale = new Locale("vn", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(money);
    }
}
