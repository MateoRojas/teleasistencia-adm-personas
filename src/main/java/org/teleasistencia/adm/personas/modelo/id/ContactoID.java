package org.teleasistencia.adm.personas.modelo.id;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Accessors(chain = true)
@Embeddable
public class ContactoID implements Serializable {

    private Integer idPersona;

    private Integer idDispostivo;
}
