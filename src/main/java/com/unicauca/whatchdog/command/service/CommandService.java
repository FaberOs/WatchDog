package com.unicauca.whatchdog.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.whatchdog.command.Model.ReportCommand;
import com.unicauca.whatchdog.command.repository.ReportCommandRepository;



    
@Service
public class CommandService {

    @Autowired
    private ReportCommandRepository reportCommandRepository;

  
    public void createReport(ReportCommand report) {
        ReportCommand reportCommand = new ReportCommand();
        reportCommand.setContent(report.getContent());
        reportCommand.setFechaCreacion(report.getFechaCreacion());
        reportCommand.setFotoUrl(report.getFotoUrl());
        reportCommandRepository.save(reportCommand);
    }

    public void updateReport(String id, ReportCommand report) {
        ReportCommand reportCommand = reportCommandRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        reportCommand.setContent(report.getContent());
        reportCommand.setFechaCreacion(report.getFechaCreacion());
        reportCommand.setFotoUrl(report.getFotoUrl());
        reportCommandRepository.save(reportCommand);
    }

    public void deleteReport(String id) {
        reportCommandRepository.deleteById(Long.valueOf(id));
    }
}
