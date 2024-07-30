package co.com.softlond.mongo.Collections;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "plantilla")
public class PlantillaCollections {

    private String nombre;
    private Date fecha;
    private String descripcion;
    private Date fechaActualizacion;
    
}