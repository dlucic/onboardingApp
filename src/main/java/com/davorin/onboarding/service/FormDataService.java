package com.davorin.onboarding.service;

import com.davorin.onboarding.model.FormData;
import com.davorin.onboarding.model.dto.FormDataDTO;
import com.davorin.onboarding.repository.FormDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormDataService {

    private FormDataRepository formDataRepository;

    @Autowired
    public FormDataService(FormDataRepository formDataRepository) {
        this.formDataRepository = formDataRepository;
    }

    public void saveFormData(FormData formData) {
        formData.getDateValue().forEach(date -> formDataRepository.saveDateValue(formData.getFormId(), date));
        formData.getLongText().forEach(longtext -> formDataRepository.saveLongTextValue(formData.getFormId(), longtext));
        formData.getMultipleChoice().forEach(choice -> formDataRepository.saveMultipleChoiceValue(formData.getFormId(), choice));
        formData.getNumberValue().forEach(number -> formDataRepository.saveNumberValue(formData.getFormId(), number));
        formData.getShortText().forEach(shorttext -> formDataRepository.saveShortTextValue(formData.getFormId(), shorttext));
        formData.getSingleChoice().forEach(choice -> formDataRepository.saveSingleChoiceValue(formData.getFormId(), choice));
        formData.getYesNo().forEach(yesno -> formDataRepository.saveYesNoValue(formData.getFormId(), yesno));
    }

    public List<FormDataDTO> getFormDataById(Long id) {
        List<FormDataDTO> data = formDataRepository.getFormDatabyId(id);

        return data;
    }
}
