package com.unicauca.watchdog.ddd.query.model;

import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("report")
public class Report {

    @Id
    private String id;
    private String content;
    //private CoordenadasUbiacion coordenadas;
    private LocalDateTime fechaCreacion;
    private String fotoUrl;

    public String getId() { 
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //public CoordenadasUbiacion getCoordenadas() {
    //    return coordenadas;
    //}
    
    //public void setCoordenadas(CoordenadasUbiacion coordenadas) {
    //    this.coordenadas = coordenadas;
    //}

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
    
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    public String getFotoUrl() {
        return fotoUrl;
    }
    
    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }
    
}
