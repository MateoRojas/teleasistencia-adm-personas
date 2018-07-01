package org.teleasistencia.adm.personas.vo.respuestas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class RecursoCreadoVO<T, K> {

    private T id;

    private K recurso;

    private Date fecha;

    private Integer estado;
}
