 package co.com.softlond.mongo.Plantilla;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.softlond.mongo.Collections.PlantillaCollections;


public interface PlantillaMongoRepository extends ReactiveMongoRepository<PlantillaCollections, String> {
    
}