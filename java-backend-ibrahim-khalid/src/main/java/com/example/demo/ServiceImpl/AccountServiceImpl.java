package com.example.demo.ServiceImpl;

import com.example.demo.DTO.AccountStatementDto;
import com.example.demo.Entity.AccountEntity;
import com.example.demo.Entity.StatementEntity;
import com.example.demo.Repository.AccountRepository;
import com.example.demo.ResponseModel.AccountStatementResponseModel;
import com.example.demo.ResponseModel.StatementResponse;
import com.example.demo.Service.AccountService;
import com.example.demo.Shared.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.ldap.StartTlsResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public AccountStatementDto getStatement1(AccountStatementDto dto)
    {
        //Crete new Account Entity to receive the result in
        AccountEntity accountEntity = new AccountEntity();

        //Call account repository to get the specified account
        accountEntity = accountRepository.findAllById(dto.getId());

        //Transfer the result of the previous line to DTO
        AccountStatementDto returnValue = new AccountStatementDto();
        BeanUtils.copyProperties(dto, returnValue);

        //Create new response list to copy StatementResponse of the Account entity to it
        List<StatementResponse> statementResponses = new ArrayList<>();
        statementResponses = StatementEntityConverter.entityToResponseConverter(accountEntity.getStatements());

        //Adding the statement response to the DTO
        BeanUtils.copyProperties(accountEntity, returnValue);
        returnValue.setStatements(statementResponses);

        //Check user's parameters and replace them with proper values if they are null
        UserInputCheck.checkInput(returnValue);

        //Filtering the result based on the parameters
        ResultFilter.filter(returnValue);

        //Hashing the Account number in order to return it to the response
        returnValue.setAccountNumber(HashFunction.Hash(returnValue.getAccountNumber()));

        return returnValue;
    }
}