package com.example.demo.Shared;

import com.example.demo.Entity.StatementEntity;
import com.example.demo.ResponseModel.StatementResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class StatementEntityConverter {

    //This functions takes StatementEntity list as input and map it to StatementResponse list as result
    public static List<StatementResponse> entityToResponseConverter(List<StatementEntity> statementEntities)
    {
        List<StatementResponse> statementResponses = new ArrayList<>();

        for(StatementEntity st: statementEntities)
        {
            StatementResponse ars = new StatementResponse();
            BeanUtils.copyProperties(st,ars);
            statementResponses.add(ars);
        }
        return statementResponses;
    }
}