package com.example.demo.RequestModel;

public class AccountStatementRequestModel {

    private int id;
    private  String fromDate;
    private String toDate;
    private String fromAmount;
    private String toAmount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(String fromAmount) {
        this.fromAmount = fromAmount;
    }

    public String getToAmount() {
        return toAmount;
    }

    public void setToAmount(String toAmount) {
        this.toAmount = toAmount;
    }

    @Override
    public String toString() {
        return "AccountStatementRequestModel{" +
                "id=" + id +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", fromAmount='" + fromAmount + '\'' +
                ", toAmount='" + toAmount + '\'' +
                '}';
    }
}