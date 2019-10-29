package com.davorin.onboarding.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormDataDTO {

    private Long id;
    private Long formId;
    private String longText;
    private String shortText;
    private Date dateValue;
    private String singleChoice;
    private String multipleChoice;
    private Integer numberValue;
    private String yesNo;
}
