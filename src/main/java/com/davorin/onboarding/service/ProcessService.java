package com.davorin.onboarding.service;

import com.davorin.onboarding.model.Form;
import com.davorin.onboarding.model.Process;
import com.davorin.onboarding.repository.ProcessFormRepository;
import com.davorin.onboarding.repository.ProcessRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessService {

    private static final Logger logger = LoggerFactory.getLogger(ProcessService.class);

    private ProcessRepository processRepository;
    private ProcessFormRepository processFormRepository;
    private FormService formService;

    @Autowired
    public ProcessService(ProcessRepository processRepository, ProcessFormRepository processFormRepository, FormService formService) {
        this.processRepository = processRepository;
        this.processFormRepository = processFormRepository;
        this.formService = formService;
    }

    public void newProcess(Process process) {
        process.setId(processRepository.getSequence());
        List<Form> forms = process.getForms();
        forms.forEach(form -> {
            formService.saveForm(form);
            processFormRepository.saveProcessForm(process.getId(), form.getId());
        });
        processRepository.saveProcess(process);
        logger.info("Process " + process.getName() + " saved.");
    }

    public List<Process> getAllProcesses(){
        List<Process> processes = processRepository.getAllProcesses();
        processes.forEach(process -> {
            List<Form> forms = formService.getFormsByProcessId(process.getId());
            formService.formSetter(forms);
            process.setForms(forms);
        });
        return processes;
    }

    public Process getProcessByUser(Long userId) {
        Process process = processRepository.getProcessByUser(userId);
        List<Form> forms = formService.getFormsByProcessId(process.getId());
        formService.formSetter(forms);
        process.setForms(forms);
        return process;
    }
}
