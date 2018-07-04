package org.teleasistencia.adm.personas.vo.consultas;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Data
@Accessors(chain = true)
public class DispositivoVO {

    private Integer id;

    @NotNull(message = "{dispositivovo.latitud.notnull}")
    private Double latitud;

    @NotNull(message = "{dispositivovo.longitud.notnull}")
    private Double longitud;

    @NotBlank(message = "{dispositivovo.numerodispositivo.notblank}")
    @Pattern(
            regexp = "^\\d{10}$",
            message = "{dispositivovo.numerodispositivo.pattern}"
    )
    private String numeroDispositivo;

    @NotBlank(message = "{validacion.calleprincipal.notblank}")
    private String callePrincipal;

    private String calleSecundaria;

    @NotBlank(message = "{validacion.numeraciondomicilio.notblank}")
    private String numeracionDomicilio;

    @NotBlank(message = "{validacion.referencia.notblank}")
    private String referencia;

    @Pattern(
            regexp = "^\\d{7,10}$",
            message = "{validacion.telefonoprincipal.pattern}"
    )
    private String telefonoPrincipal;

    @NotBlank(message = "{dispositivovo.rutaimagencasa.notblank}")
    private String rutaImagenCasa;

    @NotBlank(message = "{dispositivovo.rutaimagenmapa.notblank}")
    private String rutaImagenMapa;

    private Integer estado;

    private Date fechaCreacion;
}
