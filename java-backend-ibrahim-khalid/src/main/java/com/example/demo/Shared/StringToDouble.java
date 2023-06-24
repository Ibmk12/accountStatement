package com.example.demo.Shared;

import java.math.BigDecimal;

public class StringToDouble {

    //Takes a String and convert it to Double
    public static Double stringToBigDecimal(String amount)
    {
        Double money = Double.valueOf(amount);

        BigDecimal result = new BigDecimal(money);

        return result.doubleValue();
    }
}