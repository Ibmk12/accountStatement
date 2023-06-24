package com.example.demo.Service;

import com.example.demo.DTO.AccountStatementDto;
import com.example.demo.Entity.StatementEntity;

import java.util.List;

public interface StatementService {

    List<StatementEntity> getAccountStatement(AccountStatementDto dto);
}