package com.example.demo.Shared;

import com.example.demo.DTO.AccountStatementDto;
import com.example.demo.ResponseModel.StatementResponse;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class UserInputCheck {

    //This function go through user's input and replace them with suitable values in case user didn't provide value
    public static AccountStatementDto checkInput(AccountStatementDto dto)
    {
        String fromDate = dto.getFromDate();
        String toDate = dto.getToDate();
        String fromAmount = dto.getFromAmount();
        String toAmount = dto.getToAmount();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String currentDate = formatter.format(date).toString();
        DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //If the user didn't specify from date it will be replaced by three months earlier from the current date
        if(fromDate.isEmpty() || fromDate == "")
        {
            LocalDate localDate = StringToDate.getDate(currentDate);
            localDate = localDate.minusMonths(3);
            String resultDate = localDate.format(formater2);
            resultDate = resultDate.replace("-",".");
            resultDate = resultDate.replace("/",".");
            dto.setFromDate(resultDate);
        }

        //If the user didn't specify to date it will be replaced the current date
        if(toDate.isEmpty() || toDate == "")
        {
            LocalDate localDate = StringToDate.getDate(currentDate);
            String resultDate = localDate.format(formater2);
            resultDate = resultDate.replace("-",".");
            resultDate = resultDate.replace("/",".");
            dto.setToDate(resultDate);
        }

        //If from amount not provided it will be replaced by the minimum amount in the client account
        if (fromAmount.isEmpty() || fromAmount == "")
        {
            Double value = new Double(0);
            for(StatementResponse statementResponse : dto.getStatements())
            {
                Double amount = StringToDouble.stringToBigDecimal(statementResponse.getAmount());
                if(amount.doubleValue() <= value.doubleValue() )
                    value = amount.doubleValue();
            }
            dto.setFromAmount(value.toString());
        }

        //If to amount not provided it will be replaced by the maximum amount in the client account
        if (toAmount.isEmpty() || toAmount == "")
        {
            Double value = new Double(0);
            for(StatementResponse statementResponse : dto.getStatements())
            {
                Double amount = StringToDouble.stringToBigDecimal(statementResponse.getAmount());
                if(amount.doubleValue() >= value.doubleValue() )
                    value = amount.doubleValue();
            }
            dto.setToAmount(value.toString());
        }
        return dto;
    }
}