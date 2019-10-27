package com.davorin.onboarding.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class Process {

    private Long id;
    private String name;
    private Long userId;
    private List<Form> forms = new ArrayList<>();

    public void addForm(Form form) {
        this.forms.add(form);
    }
}
