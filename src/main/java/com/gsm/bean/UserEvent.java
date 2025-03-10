package com.gsm.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEvent {
    private int userEventID;
    private int userID;
    private int eventID;
    private Date participationTime;
    private boolean isWinner;
    private Integer prizeID; // 使用包装类型以允许 null
}
