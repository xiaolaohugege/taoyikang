package com.gsm.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRedeem {
    private int redeemID;
    private int userEventID;
    private String redeemCode;
    private String redeemStatus;
    private Date redeemTime;
}
