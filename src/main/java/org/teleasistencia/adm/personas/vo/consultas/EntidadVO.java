package org.teleasistencia.adm.personas.vo.consultas;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Accessors(chain = true)
public class EntidadVO {

    private Integer id;

    @NotNull
    @Positive
    private Integer idTipoEntidad;

    @NotBlank(message = "{entidadvo.nombre.notblank}")
    private String nombre;

    @NotBlank(message = "{validacion.calleprincipal.notblank}")
    private String callePrincipal;

    private String calleSecundaria;

    @NotBlank(message = "{validacion.numeraciondomicilio.notblank}")
    private String numeracionDomicilio;

    @NotBlank(message = "{validacion.referencia.notblank}")
    private String referencia;

    @NotBlank(message = "{validacion.telefonoprincipal.notblank}")
    @Pattern(
            regexp = "^\\d{7,10}$",
            message = "{personavo.telefonoprincipal.pattern}"
    )
    private String telefonoPrincipal;

    private String telefonoSecundario;

    @NotBlank(message = "{validacion.celular.notblank}")
    @Pattern(
            regexp = "^\\d{10}$",
            message = "{validacion.celular.pattern}"
    )
    private String celular;

    @Email(message = "{validacion.email}")
    @NotBlank(message = "{validacion.email.notblank}")
    private String email;

    private Integer estado;

    private Date fechaCreacion;

}
