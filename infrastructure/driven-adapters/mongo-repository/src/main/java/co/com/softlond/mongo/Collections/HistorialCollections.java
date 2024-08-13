package co.com.softlond.mongo.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "historial")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistorialCollections {
    @Id
    private String id;
    private Integer contador;
    private String lastDescription;

}
