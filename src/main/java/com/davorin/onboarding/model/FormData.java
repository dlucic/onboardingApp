package com.davorin.onboarding.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FormData {

    private String longText;
    private String shortText;
    private Date date;
    private String singleChoice;
    private List<String> multipleChoice;
    private Integer number;
    private boolean yesNo;
}
