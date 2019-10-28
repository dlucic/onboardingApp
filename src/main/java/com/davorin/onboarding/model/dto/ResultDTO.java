package com.davorin.onboarding.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResultDTO {

    @JsonProperty("dateOfBirth")
    private DateOfBirthDTO dateOfBirthDTO;

    private String primaryID;
    private String secondaryID;
    private String sex;


}
