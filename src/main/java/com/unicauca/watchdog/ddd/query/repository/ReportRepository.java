package com.unicauca.watchdog.ddd.query.repository;
import com.unicauca.watchdog.ddd.query.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository <Report, String> {

}
