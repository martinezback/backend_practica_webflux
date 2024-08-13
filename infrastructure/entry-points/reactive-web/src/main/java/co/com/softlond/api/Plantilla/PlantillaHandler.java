package co.com.softlond.api.Plantilla;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.api.ResponseHandler.CustomResponse;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.usecase.Plantilla.PlantillaOperationsUseCase;
import reactor.core.publisher.Mono;

@Service
public class PlantillaHandler {
    
    private final PlantillaOperationsUseCase plantillaOperationsUseCase;

    public PlantillaHandler(PlantillaOperationsUseCase plantillaOperationsUseCase) {
        this.plantillaOperationsUseCase = plantillaOperationsUseCase;
    }

    public Mono<ServerResponse> savePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaOperationsUseCase::savePlantilla)
                .flatMap(plantilla -> ServerResponse.status(HttpStatus.CREATED).bodyValue(CustomResponse.builder().statusCode(HttpStatus.CREATED.value()).message("Plantilla Creada").data(plantilla).build()))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> udpatePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaOperationsUseCase::updatePlantilla)
                .flatMap(plantilla -> ServerResponse.status(HttpStatus.ACCEPTED).bodyValue(CustomResponse.builder().statusCode(HttpStatus.ACCEPTED.value()).message("Plantilla Actualizada").data(plantilla).build()))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }


}
