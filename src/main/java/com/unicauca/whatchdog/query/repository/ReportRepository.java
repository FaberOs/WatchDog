package com.unicauca.whatchdog.query.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.unicauca.whatchdog.query.Model.Report;

@Repository
public interface ReportRepository extends MongoRepository <Report, String> {

}
