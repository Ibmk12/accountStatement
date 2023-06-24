package com.example.demo.Entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "account")
public class AccountEntity implements Serializable{

    private static final long serialVersionUID = 51L;
    @Id
    @GeneratedValue
    int id;

    @Column(length = 45)
    String accountType;

    @Column(length = 255)
    String accountNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private List<StatementEntity> statements;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<StatementEntity> getStatements() {
        return statements;
    }

    public void setStatements(List<StatementEntity> statements) {
        this.statements = statements;
    }
}