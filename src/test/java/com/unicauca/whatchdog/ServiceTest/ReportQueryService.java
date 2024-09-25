package com.unicauca.whatchdog.ServiceTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unicauca.whatchdog.query.Model.Report;
import com.unicauca.whatchdog.query.repository.ReportRepository;
import com.unicauca.whatchdog.query.service.ReportService;

@ExtendWith(MockitoExtension.class)
public class ReportQueryService {

        @InjectMocks
        private ReportService reportService;

        @Mock
        private ReportRepository reportRepository;

        @Test
        void returnReportSuccessfully() {
            // Arrange
            Report report = new Report();
            report.setId("R123");
            report.setContent("Contenido del reporte");

            when(reportRepository.findById("R123")).thenReturn(Optional.of(report));

            // Act
            Report result = reportService.getReport("R123");

            // Assert
            assertNotNull(result);
            assertEquals("R123", result.getId());
            verify(reportRepository, times(1)).findById("R123");
    }
}
