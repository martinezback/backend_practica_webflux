package co.com.softlond.mongo.Plantilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.mongo.Collections.PlantillaCollections;
import reactor.core.publisher.Mono;

@Service
public class ServicePlantillaImpl implements PlantillaRepositoryInter {

    @Autowired
    private PlantillaMongoRepository plantillaMongoRepository;

    @Override
    public Mono<PlantillaCollections> savePlantilla(PlantillaCollections plantilla) {
        return plantillaMongoRepository.save(plantilla);
    }

}
