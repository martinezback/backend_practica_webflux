package co.com.softlond.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String telefono;
}
