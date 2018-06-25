package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Accessors(chain = true)
public class Entidad {

    // Id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEntidad")
    private Integer id;

    // Atributos

    private String nombre;

    private String callePrincipal;

    private String calleSecundaria;

    private String numeracionDomicilio;

    private String referencia;

    private String telefonoPrincipal;

    private String telefonoSecundario;

    private String celular;

    private String email;

    private Integer estado;

    // Relaciones

    @OneToMany(mappedBy = "entidad")
    private Collection<EntidadDispositivo> entidadDispositivoCol;
}
