package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
public class Persona {

    // Id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona")
    private Integer id;

    // Atributos

    private Integer idGenero;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;

    private String cedula;

    private Date fechaNacimiento;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGenero", referencedColumnName = "idCatalogo", insertable = false, updatable = false)
    private Catalogo genero;
}
