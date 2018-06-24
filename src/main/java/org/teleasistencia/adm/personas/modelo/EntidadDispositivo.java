package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.teleasistencia.adm.personas.modelo.id.EntidadDispositivoID;

@Data
@Accessors(chain = true)
public class EntidadDispositivo {

    private EntidadDispositivoID id;
    private Double distancia;
    private Integer estado;
}
