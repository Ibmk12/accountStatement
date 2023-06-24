package com.example.demo.Repository;

import com.example.demo.Entity.AccountEntity;
import com.example.demo.Entity.ImageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ImageEntity,Long> {

    ImageEntity findById(long id);
}
