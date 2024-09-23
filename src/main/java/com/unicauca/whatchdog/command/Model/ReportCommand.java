package com.unicauca.whatchdog.command.Model;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class ReportCommand {

    @Id
    private String id;
    private String content;
    //private CoordenadasUbiacion coordenadas;
    private LocalDateTime fechaCreacion;
    private String fotoUrl;
}
