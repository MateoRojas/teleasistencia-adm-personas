package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Categoria {

    private Integer id;

    private String abreviacion;

    private String nombre;

    private String descripcion;
}
