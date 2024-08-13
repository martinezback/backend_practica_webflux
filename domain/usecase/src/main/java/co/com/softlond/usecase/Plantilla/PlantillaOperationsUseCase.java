package co.com.softlond.usecase.Plantilla;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import co.com.softlond.usecase.Historial.HistorialUseCase;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;



@Service
public class PlantillaOperationsUseCase  {


    @Autowired
    private HistorialUseCase historialUseCase;
    @Autowired
    private final PlantillaGateways plantillaGateways;

    public PlantillaOperationsUseCase(PlantillaGateways plantillaGateways) {
        this.plantillaGateways = plantillaGateways;
    }

   

    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        return plantillaGateways.savePlantilla(plantilla)
        .doOnSuccess(savedplantilla->{
            createHistorial(savedplantilla)
            .subscribeOn(Schedulers.boundedElastic()).subscribe();
        });
    }


    public Mono<PlantillaModel> updatePlantilla(PlantillaModel plantilla) {
        return plantillaGateways.savePlantilla(plantilla)
        .doOnSuccess(savedplantilla->{
            updateHistorial(savedplantilla)
            .subscribeOn(Schedulers.boundedElastic()).subscribe();
        });
    }


    private Mono<Void> updateHistorial(PlantillaModel plantilla){
        return historialUseCase.getHistorial()
        .flatMap(history->{
            history.setLastDescription(plantilla.getDescripcion());;
            return historialUseCase.saveHistorial(history);
        }).then();
    }
    

    private Mono<Void> createHistorial(PlantillaModel plantilla){
        return historialUseCase.getHistorial()
        .defaultIfEmpty(HistorialModel.builder().lastDescription(plantilla.getDescripcion()).build())
        .flatMap(history->{
            history.setContador(null== history.getContador() ? 1 : history.getContador()+1);
            history.setLastDescription(plantilla.getDescripcion());
            return historialUseCase.saveHistorial(history);
        }).then();
    }
    
}
