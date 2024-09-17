package com.unicauca.watchdog.ddd.sync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.watchdog.ddd.sync.service.SyncService;

@RestController
public class SyncController {

    @Autowired
    private SyncService syncService;
  
    @PostMapping("/sync")
    public void sync() {
      syncService.sync();
    }
    
}
