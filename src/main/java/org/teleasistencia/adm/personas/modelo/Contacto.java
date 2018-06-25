package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.teleasistencia.adm.personas.modelo.id.ContactoID;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
public class Contacto {

    // Id

    @EmbeddedId
    private ContactoID id;

    // Atributos

    private Integer idPartentesco;

    private Double distacia;

    private Integer estado;

    // Relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona", referencedColumnName = "idPersona", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDispositivo", referencedColumnName = "idDispositivo", insertable = false, updatable = false)
    private Dispositivo dispositivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idParentesco", referencedColumnName = "idCatalogo", insertable = false, updatable = false)
    private Catalogo parentesco;
}
