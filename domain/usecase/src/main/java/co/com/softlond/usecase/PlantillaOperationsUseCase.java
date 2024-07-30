package co.com.softlond.usecase;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaRepository;
import reactor.core.publisher.Mono;

@Service
public class PlantillaOperationsUseCase {

    @Autowired
    private PlantillaRepository plantillaRepository;

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {

    /* Logica */
    plantilla.setFecha(new Date(System.currentTimeMillis()));

    return plantillaRepository.savePlantilla(plantilla);
    }
    
}
