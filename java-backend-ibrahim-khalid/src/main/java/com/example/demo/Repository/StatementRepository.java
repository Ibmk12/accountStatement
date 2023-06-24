package com.example.demo.Repository;

import com.example.demo.Entity.StatementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatementRepository extends CrudRepository<StatementEntity, Integer> {

    List<StatementEntity> findStatementByAccountId(int id);
}