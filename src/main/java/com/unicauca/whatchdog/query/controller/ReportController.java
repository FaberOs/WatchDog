package com.unicauca.whatchdog.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.whatchdog.query.Model.Report;
import com.unicauca.whatchdog.query.service.ReportService;

@RestController
@RequestMapping("/api/V1")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/report/{id}")
    public Report getReport(@PathVariable String id) {
        return reportService.getReport(id);
    }
}
