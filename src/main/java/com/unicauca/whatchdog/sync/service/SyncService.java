package com.unicauca.whatchdog.sync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unicauca.whatchdog.command.Model.ReportCommand;
import com.unicauca.whatchdog.command.repository.ReportCommandRepository;
import com.unicauca.whatchdog.query.Model.Report;
import com.unicauca.whatchdog.query.repository.ReportRepository;

@Service
public class SyncService {

    @Autowired
    private ReportCommandRepository reportCommandRepository;

    @Autowired
    private ReportRepository reportRepository;

    // Sincroniza todos los reportes de MySQL a MongoDB
    public void syncAllReports() {
        Iterable<ReportCommand> reportCommands = reportCommandRepository.findAll();
        
        for (ReportCommand reportCommand : reportCommands) {
            Report reportQuery = reportRepository.findById(reportCommand.getId())
                    .orElse(new Report());

            // Copia los datos de MySQL a MongoDB
            reportQuery.setId(reportCommand.getId());
            reportQuery.setContent(reportCommand.getContent());
            reportQuery.setFechaCreacion(reportCommand.getFechaCreacion());
            reportQuery.setFotoUrl(reportCommand.getFotoUrl());

            // Guarda en MongoDB
            reportRepository.save(reportQuery);
        }
    }

    // Eliminar reporte de MongoDB por ID
    public void deleteReportFromMongo(String id) {
        // Verificar si el reporte existe en MongoDB antes de eliminar
        if (reportRepository.existsById(id)) {
            reportRepository.deleteById(id);
        } else {
            System.out.println("Report with id " + id + " not found in MongoDB");
        }
    }
}
