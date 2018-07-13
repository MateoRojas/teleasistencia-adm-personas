package org.teleasistencia.adm.personas.vo.respuestas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class VistaContactoVO {

    private Integer idPersona;

    private Integer idDispositivo;

    private String primerNombre;

    private String primerApellido;

    private String cedula;

    private String parentesco;

    private Double distancia;

    private String telefonoPrincipal;

    private String callePrincipal;

    private String numeracionDomicilio;
}
