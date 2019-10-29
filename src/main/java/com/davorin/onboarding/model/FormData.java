package com.davorin.onboarding.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FormData {

    private Long id;
    private Long formId;
    private List<String> longText = new ArrayList<>();
    private List<String> shortText = new ArrayList<>();
    private List<Date> dateValue = new ArrayList<>();
    private List<String> singleChoice = new ArrayList<>();
    private List<String> multipleChoice = new ArrayList<>();
    private List<Integer> numberValue = new ArrayList<>();
    private List<String> yesNo = new ArrayList<>();
}
