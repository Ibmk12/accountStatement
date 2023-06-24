package com.example.demo.DTO;

import com.example.demo.Entity.StatementEntity;
import com.example.demo.ResponseModel.StatementResponse;

import java.io.Serializable;
import java.util.List;

public class AccountStatementDto {

    private int id;
    private  String fromDate;
    private String toDate;
    private String fromAmount;
    private String toAmount;
    private String AccountNumber;
    private String hashedAccountNumber;
    private String accountType;
    private List<StatementResponse> statements;

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

    public String getHashedAccountNumber() {
        return hashedAccountNumber;
    }

    public void setHashedAccountNumber(String hashedAccountNumber) {
        this.hashedAccountNumber = hashedAccountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public List<StatementResponse> getStatements() {
        return statements;
    }

    public void setStatements(List<StatementResponse> statements) {
        this.statements = statements;
    }
}