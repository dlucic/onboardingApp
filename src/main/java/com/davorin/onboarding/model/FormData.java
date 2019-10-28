package com.davorin.onboarding.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FormData {

    private Long id;
    private Long formId;
    private List<String> longText;
    private List<String> shortText;
    private List<Date> date;
    private List<String> singleChoice;
    private List<String> multipleChoice;
    private List<Integer> number;
    private List<String> yesNo;
}
