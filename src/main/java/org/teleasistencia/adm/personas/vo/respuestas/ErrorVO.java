package org.teleasistencia.adm.personas.vo.respuestas;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorVO {

    private Integer numero;

    private String mensaje;

    private String descripcion;
}
