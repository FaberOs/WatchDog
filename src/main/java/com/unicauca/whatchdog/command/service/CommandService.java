package com.unicauca.whatchdog.command.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unicauca.whatchdog.command.Model.ReportCommand;
import com.unicauca.whatchdog.command.repository.ReportCommandRepository;
import com.unicauca.whatchdog.sync.service.SyncService;

@Service
public class CommandService {

    @Autowired
    private ReportCommandRepository reportCommandRepository;

    @Autowired
    private SyncService syncService; 

    public void createReport(ReportCommand report) {
        reportCommandRepository.save(report);
        syncService.syncAllReports();
    }

    public void updateReport(String id, ReportCommand report) {
        ReportCommand reportCommand = reportCommandRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        reportCommand.setContent(report.getContent());
        reportCommand.setFechaCreacion(report.getFechaCreacion());
        reportCommand.setFotoUrl(report.getFotoUrl());

        reportCommandRepository.save(reportCommand);

        syncService.syncAllReports();
    }

    public void deleteReport(String id) {
        reportCommandRepository.deleteById(id);
        syncService.deleteReportFromMongo(id);
    }
}
