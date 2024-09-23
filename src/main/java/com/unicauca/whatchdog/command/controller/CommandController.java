package com.unicauca.whatchdog.command.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.unicauca.whatchdog.command.Model.ReportCommand;
import com.unicauca.whatchdog.command.service.CommandService;


@RestController

public class CommandController {
    
    @Autowired
    private CommandService reportCommandService;

    @PostMapping("/report")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReport(@RequestBody ReportCommand report) {
        reportCommandService.createReport(report);
    }

    @PutMapping("/report/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateReport(@PathVariable String id, @RequestBody ReportCommand report) {
        reportCommandService.updateReport(id, report);
    }

    @DeleteMapping("/report/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReport(@PathVariable String id) {
        reportCommandService.deleteReport(id);
    }
}
