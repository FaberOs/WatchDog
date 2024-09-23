package com.unicauca.whatchdog.command.Model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class ReportCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    //private CoordenadasUbiacion coordenadas;
    private LocalDateTime fechaCreacion;
    private String fotoUrl;
}
