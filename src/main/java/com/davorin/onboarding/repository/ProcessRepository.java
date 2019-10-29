package com.davorin.onboarding.repository;

import com.davorin.onboarding.model.Process;

import java.util.List;

public interface ProcessRepository {

    List<Process> getAllProcesses();

    void saveProcess(Process process);

    Long getSequence();

    Process getProcessByUser(Long userId);

    void deleteProcess(Long id);
}
