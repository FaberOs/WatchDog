package com.unicauca.whatchdog.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.whatchdog.query.Model.Report;
import com.unicauca.whatchdog.query.repository.ReportRepository;

@Service
public class ReportService {

    @Autowired
    ReportRepository reportRepository;

    public Report getReport(String id) {
    return reportRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
