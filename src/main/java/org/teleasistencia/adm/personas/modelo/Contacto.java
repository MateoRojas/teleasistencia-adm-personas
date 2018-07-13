package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.teleasistencia.adm.personas.modelo.id.ContactoID;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

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

    // Auditoria

    private Integer estado;

    private Date fechaCreacion;

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
