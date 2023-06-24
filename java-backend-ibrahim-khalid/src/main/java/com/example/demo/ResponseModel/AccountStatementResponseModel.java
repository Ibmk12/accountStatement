package com.example.demo.ResponseModel;

import com.example.demo.Entity.StatementEntity;

import java.util.List;

public class AccountStatementResponseModel {

    private int id;
    private String accountNumber;
    private String accountType;
    private List<StatementResponse> statements;
    //private List<StatementEntity> statements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.accountNumber = AccountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<StatementResponse> getStatements() {
        return statements;
    }

    public void setStatements(List<StatementResponse> statements) {
        this.statements = statements;
    }
}