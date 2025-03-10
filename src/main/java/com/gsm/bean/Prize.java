package com.gsm.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prize {
    private int prizeID;
    private int eventID;
    private String prizeLevel;
    private String prizeName;
    private String prizeImageURL;
    private String prizeType;
    private double probability;
    private String redemptionCode;
    private String redemptionInstructions;
}
