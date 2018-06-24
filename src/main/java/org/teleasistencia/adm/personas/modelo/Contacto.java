package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.teleasistencia.adm.personas.modelo.id.ContactoID;

@Data
@Accessors(chain = true)
public class Contacto {

    private ContactoID id;

    private Integer idPartentesco;

    private Double distacia;

    private Integer estado;
}
