package com.unicauca.whatchdog.ControlerTest;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unicauca.whatchdog.command.Model.ReportCommand;
import com.unicauca.whatchdog.command.controller.CommandController;
import com.unicauca.whatchdog.command.service.CommandService;


@WebMvcTest(CommandController.class)
public class ReportCommandControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommandService commandService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateReport() throws Exception {
        // Arrange
        ReportCommand report = new ReportCommand();
        report.setContent("Sample content");

        // Act & Assert
        mockMvc.perform(post("/report")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(report)))
                .andExpect(status().isCreated());

        verify(commandService, times(1)).createReport(any(ReportCommand.class));
    }

    @Test
    void shouldUpdateReport() throws Exception {
        // Arrange
        ReportCommand updatedReport = new ReportCommand();
        updatedReport.setContent("Updated content");

        // Act & Assert
        mockMvc.perform(put("/report/{id}", "123")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedReport)))
                .andExpect(status().isOk());

        verify(commandService, times(1)).updateReport(eq("123"), any(ReportCommand.class));
    }

    @Test
    void shouldDeleteReport() throws Exception {
        // Act & Assert
        mockMvc.perform(delete("/report/{id}", "123"))
                .andExpect(status().isNoContent());

        verify(commandService, times(1)).deleteReport("123");
    }

}
