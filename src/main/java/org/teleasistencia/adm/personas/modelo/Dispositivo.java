package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Dispositivo {

    private Integer id;

    private Double latitud;

    private Double longitud;

    private String numeroDispositivo;

    private String callePrincipal;

    private String calleSecundaria;

    private String numeracionDomicilio;

    private String referencia;

    private String telefonoPrincipal;

    private String rutaImagenCasa;

    private String rutaImagenMapa;

    private Integer estado;
}
