package com.davorin.onboarding.model;

import lombok.Data;

import java.util.List;

@Data
public class Form {

    private long id;
    private String name;
    private boolean longText;
    private boolean shortText;
    private boolean date;
    private boolean singleChoice;
    private boolean multipleChoice;
    private boolean number;
    private boolean yesNo;
    private List<Field> fields;

    public void addField(Field field) {
        this.fields.add(field);
    }

//    napraviti multi select sa svim fieldovima kao i za process sa formama
}
