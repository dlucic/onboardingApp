package com.davorin.onboarding.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Field {

    private long id;
    private String label;
    private String type;
    private List<FieldValue> fieldValues = new ArrayList<>();

    public void addFieldValue(FieldValue fieldValue){
        this.fieldValues.add(fieldValue);
    }
}
