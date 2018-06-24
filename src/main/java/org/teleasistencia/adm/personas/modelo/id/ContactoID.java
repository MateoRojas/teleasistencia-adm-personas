package org.teleasistencia.adm.personas.modelo.id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ContactoID {

    private Integer idPersona;

    private Integer idDispostivo;
}
