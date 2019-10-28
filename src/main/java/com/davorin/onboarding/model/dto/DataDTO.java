package com.davorin.onboarding.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DataDTO {

    @JsonProperty("result")
    private ResultDTO resultDTO;
}
