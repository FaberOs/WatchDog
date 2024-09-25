package com.unicauca.whatchdog.ServiceTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.unicauca.whatchdog.command.Model.ReportCommand;
import com.unicauca.whatchdog.command.repository.ReportCommandRepository;
import com.unicauca.whatchdog.command.service.CommandService;




@ExtendWith(MockitoExtension.class)
public class ReportCommandServiceTest {

    @InjectMocks
    private CommandService commandService;

    @Mock
    private ReportCommandRepository reportCommandRepository;

    @Test
    void createReportSuccessfully() {
        // Arrange
        ReportCommand report = new ReportCommand();
        report.setId("R123");
        report.setContent("Contenido del Reporte");
        report.setFechaCreacion(LocalDateTime.now());
        report.setFotoUrl("http://fotoReporte.com/photo.jpg");

        // Act
        commandService.createReport(report);

        // Assert
        verify(reportCommandRepository, times(1)).save(any(ReportCommand.class));
    }

    @Test
    void updateReportSuccessfully() {
        // Arrange
        ReportCommand existingReport = new ReportCommand();
        existingReport.setId("R123");
        existingReport.setContent("Viejo Contenido");

        when(reportCommandRepository.findById("R123")).thenReturn(Optional.of(existingReport));

        ReportCommand updatedReport = new ReportCommand();
        updatedReport.setContent("Contenido Actualizado");
        updatedReport.setFechaCreacion(LocalDateTime.now());
        updatedReport.setFotoUrl("http://example.com/newphoto.jpg");

        // Act
        commandService.updateReport("R123", updatedReport);

        // Assert
        verify(reportCommandRepository, times(1)).save(existingReport);
        assertEquals("Contenido Actualizado", existingReport.getContent());
    }

    @Test
    void deleteReportSuccessfully() {
        // Act
        commandService.deleteReport("R123");

        // Assert
        verify(reportCommandRepository, times(1)).deleteById("R123");
    }
}
