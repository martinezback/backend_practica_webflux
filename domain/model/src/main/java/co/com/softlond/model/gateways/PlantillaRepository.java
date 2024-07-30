package co.com.softlond.model.gateways;

import co.com.softlond.model.PlantillaModel;
import reactor.core.publisher.Mono;

public interface PlantillaRepository {
    Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla);
}
