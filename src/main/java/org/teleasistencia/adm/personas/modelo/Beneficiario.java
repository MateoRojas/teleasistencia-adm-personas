package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
public class Beneficiario {

    // Id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Integer id;

    // Atributos

    private Integer idDispositivo;

    private Integer idTipoSangre;

    private String rutaImagen;

    private Integer estado;

    // Relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "idPersona", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDispositivo", referencedColumnName = "idDispositivo", insertable = false, updatable = false)
    private Dispositivo dispositivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoSangre", referencedColumnName = "idCatalogo", insertable = false, updatable = false)
    private Catalogo tipoSangre;
}
