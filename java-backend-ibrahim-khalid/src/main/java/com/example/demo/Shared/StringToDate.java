package com.example.demo.Shared;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class StringToDate {
    //Takes a String and converts it to LocalDate with the following format "dd/MM/yyyy"
    public static LocalDate getDate(String date)
    {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatedDateString = date.replace(".","/");
        LocalDate resultDate = LocalDate.parse(formatedDateString, formater);
        return resultDate;
    }
}