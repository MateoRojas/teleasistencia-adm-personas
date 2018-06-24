package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Beneficiario {

    private Integer idPersona;

    private Integer idDispositivo;

    private Integer idTipoSangre;

    private String rutaImagen;

    private Integer estado;
}
