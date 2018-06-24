package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Entidad {

    private Integer id;

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
}
