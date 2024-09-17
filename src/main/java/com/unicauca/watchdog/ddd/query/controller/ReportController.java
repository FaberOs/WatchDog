package com.unicauca.watchdog.ddd.query.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.watchdog.ddd.query.model.Report;
import com.unicauca.watchdog.ddd.query.service.ReportService;

@RestController
public class ReportController {
    @Autowired
    private ReportService queryService;

    @GetMapping("/post/{id}")
    public Report getReport(@PathVariable String id) {
        return queryService.getReport(id);
    }
}
