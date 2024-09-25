package com.unicauca.whatchdog.TestService;

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
        void shouldReturnReportSuccessfully() {
            // Arrange
            Report report = new Report();
            report.setId("123");
            report.setContent("Sample content");

            when(reportRepository.findById("123")).thenReturn(Optional.of(report));

            // Act
            Report result = reportService.getReport("123");

            // Assert
            assertNotNull(result);
            assertEquals("123", result.getId());
            verify(reportRepository, times(1)).findById("123");
    }
}
