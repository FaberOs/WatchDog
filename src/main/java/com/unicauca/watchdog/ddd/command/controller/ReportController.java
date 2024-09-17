package com.unicauca.watchdog.ddd.command.controller;
import com.unicauca.watchdog.ddd.command.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReportController {

    @Autowired
    private ReportService commandService;
}
