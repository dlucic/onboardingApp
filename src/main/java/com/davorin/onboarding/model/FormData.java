package com.davorin.onboarding.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;
import java.util.List;

@Data
public class FormData {

    private Long id;
    private Long formId;
    private List<String> longText;
    private List<String> shortText;
    private List<Date> dateValue;
    private List<String> singleChoice;
    private List<String> multipleChoice;
    private List<Integer> numberValue;
    private List<String> yesNo;
}
