package org.teleasistencia.adm.personas.modelo.id;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;

@Data
@Accessors(chain = true)
@Embeddable
public class EntidadDispositivoID {

    private Integer idEntidad;

    private Integer idDispositivo;
}
