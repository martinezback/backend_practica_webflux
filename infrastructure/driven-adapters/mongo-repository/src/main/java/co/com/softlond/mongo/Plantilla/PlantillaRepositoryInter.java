package co.com.softlond.mongo.Plantilla;

import co.com.softlond.mongo.Collections.PlantillaCollections;
import reactor.core.publisher.Mono;

public interface PlantillaRepositoryInter {
    Mono<PlantillaCollections> savePlantilla(PlantillaCollections plantilla);
}
