package com.gsm.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private int eventID;
    private int moduleID;
    private String title;
    private Date eventTime;
    private String announcement;
    private String description;
}
