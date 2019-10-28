package com.davorin.onboarding.model.dto;

import lombok.Data;

@Data
public class MicroblinkImageRequestDTO {

    private String recognizerType;
    private String imageBase64;

}
