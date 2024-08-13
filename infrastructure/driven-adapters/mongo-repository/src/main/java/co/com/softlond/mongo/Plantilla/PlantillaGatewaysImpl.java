package co.com.softlond.mongo.Plantilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import reactor.core.publisher.Mono;

@Repository
public class PlantillaGatewaysImpl implements PlantillaGateways {    

    @Autowired
    private ReactivePlantillaMongoRepository reactivePlantillaMongoRepository;

    @Override
    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla) {
        return reactivePlantillaMongoRepository.save(PlantillaMapper.toCollection(plantilla))
                .map(plantillaEntity -> PlantillaMapper.toModel(plantillaEntity));
    }

    @Override
    public Mono<PlantillaModel> findById(String id) {
        return reactivePlantillaMongoRepository.findById(id).map(plantilla-> PlantillaMapper.toModel(plantilla));
    }

    @Override
    public Mono<Boolean> findOne() {
        return reactivePlantillaMongoRepository.count()
            .map(count -> count > 0); 
    }

    @Override
    public Mono<Boolean> existByid(String id) {
        return reactivePlantillaMongoRepository.existsById(id);
    }

    @Override
    public Mono<PlantillaModel> updatePlantilla(PlantillaModel plantilla) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePlantilla'");
    }
    
}
