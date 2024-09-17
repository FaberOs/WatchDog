package com.unicauca.watchdog.ddd.sync.service;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

@Service
public class SyncService {
    Date lastSyncDate = new Date();

    @Autowired
    private MongoOperations mongoOps;

    public void sync() {
        Date newSyncDate = new Date();
        lastSyncDate = newSyncDate;
    }
}
