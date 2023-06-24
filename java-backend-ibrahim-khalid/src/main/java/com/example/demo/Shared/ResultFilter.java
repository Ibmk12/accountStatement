package com.example.demo.Shared;

import com.example.demo.DTO.AccountStatementDto;
import com.example.demo.ResponseModel.StatementResponse;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResultFilter {

    public static AccountStatementDto filter(AccountStatementDto dto)
    {
        //Converting String values in DTO to suitable types in order to perform arithmetic operations
        Double fromAmount = StringToDouble.stringToBigDecimal(dto.getFromAmount());
        Double toAmount = StringToDouble.stringToBigDecimal(dto.getToAmount());
        LocalDate fromDate = StringToDate.getDate(dto.getFromDate());
        LocalDate toDate = StringToDate.getDate(dto.getToDate());

        //New list that will hold the desired result
        List<StatementResponse> result = new ArrayList<>();

        //This loop will go through the entire result and filter only the desired objects based on the specified conditions
        for(StatementResponse st: dto.getStatements())
        {
            //Converting String values to suitable types in order to perform arithmetic operations
            Double amount = StringToDouble.stringToBigDecimal(st.getAmount());
            LocalDate date = StringToDate.getDate(st.getDate());

            StatementResponse temp = new StatementResponse();
            BeanUtils.copyProperties(st,temp);
            if(amount.doubleValue() >= fromAmount.doubleValue() &&
               amount.doubleValue() <= toAmount.doubleValue() &&
                    (date.isAfter(fromDate) || date.isEqual(fromDate)) &&
                    (date.isBefore(toDate) || (date.isEqual(toDate))))
            {
                result.add(temp);
            }
        }
            dto.setStatements(result);
            return dto;
    }
}