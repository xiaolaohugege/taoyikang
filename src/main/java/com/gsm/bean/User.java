package com.gsm.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int userID;
    private String userName;
    private String passwordHash;
    private String email;
    private String verificationCode;
    private Date codeExpiration;
    private String avatarURL;
}
