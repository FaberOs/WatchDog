package com.unicauca.whatchdog.ControlerTest;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.web.server.ResponseStatusException;

import com.unicauca.whatchdog.query.Model.Report;
import com.unicauca.whatchdog.query.controller.ReportController;
import com.unicauca.whatchdog.query.service.ReportService;

@WebMvcTest(ReportController.class)
public class ReportQueryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;

    @Test
    void returnReportSuccessfully() throws Exception {
        // Arrange
        Report report = new Report();
        report.setId("123");
        report.setContent("Sample content");

        when(reportService.getReport("123")).thenReturn(report);

        // Act & Assert
        mockMvc.perform(get("/api/V1/report/{id}", "123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("123"))
                .andExpect(jsonPath("$.content").value("Sample content"));

        verify(reportService, times(1)).getReport("123");
    }

    @Test
    void returnNotFoundWhenReportDoesNotExist() throws Exception {
        // Arrange
        when(reportService.getReport("123")).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        // Act & Assert
        mockMvc.perform(get("/api/V1/report/{id}", "123"))
                .andExpect(status().isNotFound());

        verify(reportService, times(1)).getReport("123");
    }
}

