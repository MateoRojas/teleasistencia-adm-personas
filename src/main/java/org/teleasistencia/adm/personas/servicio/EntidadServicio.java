package org.teleasistencia.adm.personas.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teleasistencia.adm.personas.comun.TeleasistenciaConstantes;
import org.teleasistencia.adm.personas.excepcion.TeleasistenciaException;
import org.teleasistencia.adm.personas.excepcion.TipoError;
import org.teleasistencia.adm.personas.modelo.Entidad;
import org.teleasistencia.adm.personas.persistencia.IEntidadRepositorio;
import org.teleasistencia.adm.personas.vo.consultas.EntidadVO;

import java.util.Date;

@Service
@Transactional
public class EntidadServicio {

    @Autowired
    private IEntidadRepositorio entidadRepositorio;

    @Autowired
    private ValidacionServicio validacionServicio;

    @Autowired
    private ModelMapper mapper;

    public EntidadVO crearEntidad(EntidadVO entidadVO) {

        this.validacionServicio.validarObjeto(entidadVO, TipoError.ENTIDAD_NULA);

        this.validarNombre(entidadVO.getNombre());

        Entidad entidad = this.guardarEntidad(entidadVO);

        return entidadVO.setId(entidad.getId())
                .setEstado(entidad.getEstado())
                .setFechaCreacion(entidad.getFechaCreacion());
    }

    private void validarNombre(String nombre) {

        if(Long.compare(0, this.entidadRepositorio.countByNombreContaining(nombre)) != 0) {

            TeleasistenciaException.throwException(TipoError.NOMBRE_ENTIDAD_REPETIDO.build());
        }
    }

    private Entidad guardarEntidad(EntidadVO entidadVO) {

        return this.entidadRepositorio
                .save(
                    this.mapper.map(entidadVO, Entidad.class)
                        .setEstado(TeleasistenciaConstantes.Estado.ACT.ordinal())
                        .setFechaCreacion(new Date())
                );
    }
}
