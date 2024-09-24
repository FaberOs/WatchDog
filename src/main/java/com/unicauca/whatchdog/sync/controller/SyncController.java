package com.unicauca.whatchdog.sync.controller;

import com.unicauca.whatchdog.sync.service.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SyncController {

  @Autowired
  private SyncService syncService;

  @PostMapping("/sync")
  public ResponseEntity<String> sync() {
    syncService.syncAllReports(); // Sincroniza todos los reportes
    return ResponseEntity.ok("Synchronization successful");
  }
}
