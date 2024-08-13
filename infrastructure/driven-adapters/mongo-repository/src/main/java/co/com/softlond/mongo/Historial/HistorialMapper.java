package co.com.softlond.mongo.Historial;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.mongo.Collections.HistorialCollections;

public class HistorialMapper {

    public static HistorialModel toModel(HistorialCollections historialCollections){
        return HistorialModel.builder()
            .id(historialCollections.getId())
            .contador(historialCollections.getContador())
            .lastDescription(historialCollections.getLastDescription())
            .build();
    }

    public static HistorialCollections toCollections(HistorialModel historialModel){
        return HistorialCollections.builder()
            .id(historialModel.getId())
            .contador(historialModel.getContador())
            .lastDescription(historialModel.getLastDescription())
            .build();

    }
    
}


