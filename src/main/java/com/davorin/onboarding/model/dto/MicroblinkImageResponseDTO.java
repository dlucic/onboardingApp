package com.davorin.onboarding.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MicroblinkImageResponseDTO {

    @JsonProperty("data")
    private DataDTO dataDTO;
}
