package com.davorin.onboarding.service;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.model.User;
import com.davorin.onboarding.repository.FormRepository;
import com.davorin.onboarding.repository.ProcessFormRepository;
import com.davorin.onboarding.repository.ProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProcessService {

    @Autowired
    private ProcessRepository processRepository;

    @Autowired
    private ProcessFormRepository processFormRepository;

    public void createProcess(Process process) {
        process.setId(processRepository.getSequence());
        List<Form> forms = process.getForms();
        forms.forEach(form -> processFormRepository.saveProcessForm(process.getId(), form.getId()));
        processRepository.saveProcess(process);
    }

    public List<Process> getAllProcesses(){
        return processRepository.getAllProcesses();
    }

    public Process getProcessByUser(int userId) {
        return processRepository.getProcessByUser(userId);
    }

}
