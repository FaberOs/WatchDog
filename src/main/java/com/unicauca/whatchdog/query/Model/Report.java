package com.unicauca.whatchdog.query.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value = "Report")
@Data
public class Report {
    @Id
    private String id;
    private String content;
    //private CoordenadasUbiacion coordenadas;
    private LocalDateTime fechaCreacion;
    private String fotoUrl;
}
