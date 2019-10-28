package com.davorin.onboarding.service;

import com.davorin.onboarding.model.FormData;
import com.davorin.onboarding.repository.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormDataService {

    private FormDataRepository formDataRepository;

    @Autowired
    public FormDataService(FormDataRepository formDataRepository) {
        this.formDataRepository = formDataRepository;
    }

    public void saveFormData(FormData formData) {
        formData.getDate().forEach(date -> formDataRepository.saveDateValue(formData.getFormId(), date));
        formData.getLongText().forEach(longtext -> formDataRepository.saveStringValue(formData.getFormId(), longtext));
        formData.getMultipleChoice().forEach(choice -> formDataRepository.saveStringValue(formData.getFormId(), choice));
        formData.getNumber().forEach(number -> formDataRepository.saveIntegerValue(formData.getFormId(), number));
        formData.getShortText().forEach(shorttext -> formDataRepository.saveStringValue(formData.getFormId(), shorttext));
        formData.getSingleChoice().forEach(choice -> formDataRepository.saveStringValue(formData.getFormId(), choice));
        formData.getYesNo().forEach(yesno -> formDataRepository.saveStringValue(formData.getFormId(), yesno));
    }


}
