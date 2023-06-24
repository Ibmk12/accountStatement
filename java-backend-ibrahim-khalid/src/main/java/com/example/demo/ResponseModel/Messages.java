package com.example.demo.ResponseModel;

public enum Messages {

    INVALID_NUMBER_FORMAT ( "Invalid amount, please enter a valid amount"),
    INVALID_DATE_FORMAT("Invalid date format, please enter a valid date in the following format dd/MM/yyyy"),
    ACCOUNT_NOT_FOUND("No such account found"),
    INVALID_USER_ACCOUNTID("Invalid Account ID, please enter a valid account Account ID"),
    UNAUTHORIZED_USER("Please insert correct username and password of an authorized user");

     private String error;
     Messages(String error)
    {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}