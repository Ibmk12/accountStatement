package com.example.demo.ResponseModel;

import com.example.demo.Entity.AgentLocation;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AgentLocationResponse {

    @JsonProperty(value = "content")
    private List<AgentLocation> agentLocations;

    public List<AgentLocation> getAgentLocations() {
        return agentLocations;
    }

    public void setAgentLocations(List<AgentLocation> agentLocations) {
        this.agentLocations = agentLocations;
    }
}
