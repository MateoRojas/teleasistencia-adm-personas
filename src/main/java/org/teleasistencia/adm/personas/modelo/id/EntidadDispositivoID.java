package org.teleasistencia.adm.personas.modelo.id;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EntidadDispositivoID {

    private Integer idEntidad;

    private Integer idDispositivo;
}
