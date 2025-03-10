package com.gsm.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    private int moduleID;
    private String moduleName;
    private String description;
    private String photoURL;
}
