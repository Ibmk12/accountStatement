package com.example.demo.ServiceImpl;

import com.example.demo.DTO.AccountStatementDto;
import com.example.demo.Entity.StatementEntity;
import com.example.demo.Repository.StatementRepository;
import com.example.demo.Service.StatementService;
import com.example.demo.Shared.StringToDate;
import com.example.demo.Shared.StringToDouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.System.in;

@Service
public class StatementServiceImpl implements StatementService{

    @Autowired
    StatementRepository statementRepository;

    @Override
    public List<StatementEntity> getAccountStatement(AccountStatementDto dto)
    {

        //Creating new DTO to recive the result on
        AccountStatementDto returnValue = new AccountStatementDto();

        //Retrieve data from DB and asign it to StatementEntity lidt
        List<StatementEntity> statements = statementRepository.findStatementByAccountId(dto.getId());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);
        Double amount = StringToDouble.stringToBigDecimal(dto.getFromAmount());

        //Filtering the data
        List<StatementEntity> result = new ArrayList<StatementEntity>();
        for(StatementEntity st : statements)
        {
            LocalDate compDate = StringToDate.getDate(st.getDate());
            if(StringToDouble.stringToBigDecimal(st.getAmount()).doubleValue() == amount.doubleValue() )
                result.add(st);
        }

        return result;
    }
}