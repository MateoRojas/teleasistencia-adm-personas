package org.teleasistencia.adm.personas.vo.respuestas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class CatalogoVO {

    private Integer id;

    private String abreviacion;

    private String nombre;

    private String descripcion;
}
