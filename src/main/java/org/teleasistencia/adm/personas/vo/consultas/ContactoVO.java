package org.teleasistencia.adm.personas.vo.consultas;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Date;

@Data
@Accessors(chain = true)
public class ContactoVO {

    @NotNull(message = "{contactovo.idpersona.notnull}")
    private Integer idPersona;

    @NotNull(message = "{contactovo.iddispositivo.notnull}")
    private Integer idDispositivo;

    @NotNull(message = "{contactovo.idparentesco.notnull}")
    private Integer idParentesco;

    @NotNull(message = "{contactovo.distancia.notnull}")
    @Positive(message = "{contactovo.distancia.positive}")
    private Double distancia;

    private Integer estado;

    private Date fechaCreacion;
}
