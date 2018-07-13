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

    private Integer id;

    @NotNull(message = "{personavo.idgenero.notnull}")
    @Positive
    private Integer idGenero;

    @NotBlank(message = "{personavo.primernombre.notblank}")
    private String primerNombre;

    private String segundoNombre;

    @NotBlank(message = "{personavo.primerapellido.notblank}")
    private String primerApellido;

    private String segundoApellido;

    @NotBlank(message = "{personavo.cedula.notblank}")
    @Pattern(
            regexp = "^\\d{10}$",
            message = "{personavo.cedula.pattern}"
    )
    private String cedula;

    @Past(message = "{personavo.fechanacimiento.past}")
    private Date fechaNacimiento;

    @NotBlank(message = "{validacion.calleprincipal.notblank}")
    private String callePrincipal;

    private String calleSecundaria;

    @NotBlank(message = "{validacion.numeraciondomicilio.notblank}")
    private String numeracionDomicilio;

    @NotBlank(message = "{validacion.referencia.notblank}")
    private String referencia;

    @NotBlank(message =  "{validacion.telefonoprincipal.notblank}")
    @Pattern(
            regexp = "^\\d{7,10}$",
            message = "{validacion.telefonoprincipal.pattern}"
    )
    private String telefonoPrincipal;

    @Pattern(
            regexp = "^\\d{7,10}$",
            message = "{validacion.telefonosecundario.pattern}"
    )
    private String telefonoSecundario;

    @Pattern(
            regexp = "^\\d{10}$",
            message = "{validacion.celular.pattern}"
    )
    private String celular;

    @Email(message = "{validacion.email}")
    private String email;

    private Date fechaCreacion;

    private Integer estado;
}
