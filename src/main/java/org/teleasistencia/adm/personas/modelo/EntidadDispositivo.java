package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.teleasistencia.adm.personas.modelo.id.EntidadDispositivoID;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
public class EntidadDispositivo {

    // Id

    @EmbeddedId
    private EntidadDispositivoID id;

    // Atributos

    private Double distancia;

    private Integer estado;

    // Relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEntidad", referencedColumnName = "idEntidad", insertable = false, updatable = false)
    private Entidad entidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDispositivo", referencedColumnName = "idDispositivo", insertable = false, updatable = false)
    private Dispositivo dispositivo;
}
