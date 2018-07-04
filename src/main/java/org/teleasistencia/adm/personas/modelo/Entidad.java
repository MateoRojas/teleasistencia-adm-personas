package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

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

    // Auditoria

    private Integer estado;

    private Date fechaCreacion;

    // Relaciones

    @OneToMany(mappedBy = "entidad")
    private Collection<EntidadDispositivo> entidadDispositivoCol;
}
