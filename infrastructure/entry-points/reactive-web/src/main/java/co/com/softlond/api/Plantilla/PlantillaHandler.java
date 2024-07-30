package co.com.softlond.api.Plantilla;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.usecase.PlantillaOperationsUseCase;
import reactor.core.publisher.Mono;

@Component
public class PlantillaHandler {
    

    private final PlantillaOperationsUseCase plantillaOperationsUseCase;

    public PlantillaHandler(PlantillaOperationsUseCase plantillaOperationsUseCase) {
        this.plantillaOperationsUseCase = plantillaOperationsUseCase;
    }

    public Mono<ServerResponse> savePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaOperationsUseCase::savePlantilla)
                .flatMap(plantilla -> ServerResponse.ok().bodyValue(plantilla))
                .switchIfEmpty(ServerResponse.noContent().build());
    }


}
