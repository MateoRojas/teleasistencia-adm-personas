package org.teleasistencia.adm.personas.vo.respuestas;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Accessors(chain = true)
public class ResultadoPaginado<T> {

    private Collection<T> datos;

    private Integer totalElementos;

    private Integer maximoPagina;

    private Integer numeroPagina;

    private Integer totalPaginas;
}
