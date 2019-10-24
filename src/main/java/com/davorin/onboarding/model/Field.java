package com.davorin.onboarding.model;

import lombok.Data;

@Data
public class Field {

    private String label;

    public Field(String label) {
        this.label = label;
    }
}
