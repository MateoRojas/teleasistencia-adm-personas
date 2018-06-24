package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Persona {

    private Integer id;

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

    private Integer estado;
}
