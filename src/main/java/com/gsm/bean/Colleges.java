package com.gsm.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Colleges {

    private int collegeId;
    private String name;
    private String schoolCode;
    private String department;
    private String location;
    private String address;
    private String educationLevel;
    private String remarks;
    private String contactInfo;
    private Date createdAt;
    private Date updatedAt;

}
