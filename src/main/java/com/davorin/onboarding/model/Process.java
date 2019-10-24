package com.davorin.onboarding.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class Process {

    @Id
    private long id;
    private String name;
    private String userId;
    private List<Form> forms;

    public void addForm(Form form) {
        this.forms.add(form);
    }
}
