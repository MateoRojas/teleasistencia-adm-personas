package org.teleasistencia.adm.personas.vo.consultas;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Accessors(chain = true)
public class PersonaVO {

    @NotNull
    @Positive
    private Integer idGenero;

    @NotBlank
    private String primerNombre;

    private String segundoNombre;

    @NotBlank
    private String primerApellido;

    private String segundoApellido;

    @NotBlank
    @Pattern(regexp = "^\\d{10}$")
    private String cedula;

    @Past
    private Date fechaNacimiento;

    @NotBlank
    private String callePrincipal;

    private String calleSecundaria;

    @NotBlank
    private String numeracionDomicilio;

    @NotBlank
    private String referencia;

    @NotBlank(message =  "{consultas.personavo.telefonoprincipal.notblank}")
    @Pattern(regexp = "^\\d{7,10}$", message = "{consultas.personavo.telefonoprincipal.pattern}")
    private String telefonoPrincipal;

    @Pattern(regexp = "^\\d{7,10}$")
    private String telefonoSecundario;

    @Pattern(regexp = "^\\d{10}$")
    private String celular;

    @Email
    private String email;
}
