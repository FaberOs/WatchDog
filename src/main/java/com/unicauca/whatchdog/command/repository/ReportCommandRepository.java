package com.unicauca.whatchdog.command.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.unicauca.whatchdog.command.Model.ReportCommand;

public interface ReportCommandRepository extends JpaRepository<ReportCommand, Long> {
}