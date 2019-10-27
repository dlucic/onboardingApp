package com.davorin.onboarding.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Form {

    private long id;
    private String name;
    private List<Field> fields = new ArrayList<>();

    public void addField(Field field) {
        this.fields.add(field);
    }
}
