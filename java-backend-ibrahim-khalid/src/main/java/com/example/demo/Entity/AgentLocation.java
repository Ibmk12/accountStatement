package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "agent_location")
public class AgentLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column
    @JsonProperty(value = "lat")
    private String latitude;

    @Column
    @JsonProperty(value = "long")
    private String longitude;

    @Column
    @JsonProperty(value = "NameAr")
    private String nameAr;

    @Column
    @JsonProperty(value = "Name")
    private String name;

    @Column
    @JsonProperty(value = "siteName")
    private String siteName;

    @Column
    @JsonProperty(value = "siteNameAr")
    private String siteNameAr;

    @Column
    @JsonProperty(value = "type")
    private String type;

    @Column
    @JsonIgnore
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameAr() {
        return siteNameAr;
    }

    public void setSiteNameAr(String siteNameAr) {
        this.siteNameAr = siteNameAr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
