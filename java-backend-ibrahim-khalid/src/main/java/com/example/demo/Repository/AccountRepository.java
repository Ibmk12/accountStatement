package com.example.demo.Repository;

import com.example.demo.Entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<AccountEntity,Integer> {

    AccountEntity findAllById(Integer id);
}