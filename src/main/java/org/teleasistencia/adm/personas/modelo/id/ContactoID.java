package org.teleasistencia.adm.personas.modelo.id;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;

@Data
@Accessors(chain = true)
@Embeddable
public class ContactoID {

    private Integer idPersona;

    private Integer idDispostivo;
}
