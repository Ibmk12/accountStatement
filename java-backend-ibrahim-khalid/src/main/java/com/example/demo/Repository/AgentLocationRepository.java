package com.example.demo.Repository;

import com.example.demo.Entity.AgentLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentLocationRepository extends CrudRepository<AgentLocation,Long> {

    List<AgentLocation> findAllByStatus(String status);
}
