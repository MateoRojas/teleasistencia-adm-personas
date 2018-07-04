package org.teleasistencia.adm.personas.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teleasistencia.adm.personas.comun.TeleasistenciaConstantes;
import org.teleasistencia.adm.personas.excepcion.TeleasistenciaException;
import org.teleasistencia.adm.personas.excepcion.TipoError;
import org.teleasistencia.adm.personas.modelo.Dispositivo;
import org.teleasistencia.adm.personas.persistencia.IDispositivoRepositorio;
import org.teleasistencia.adm.personas.vo.consultas.DispositivoVO;

import java.util.Date;

@Service
@Transactional
public class DispositivoServicio {

    @Autowired
    private IDispositivoRepositorio dispositivoRepositorio;

    @Autowired
    private ValidacionServicio validacionServicio;

    @Autowired
    private ModelMapper mapper;

    public DispositivoVO crearDispositivo(DispositivoVO dispositivoVO) {

        this.validacionServicio.validarObjeto(dispositivoVO, TipoError.DISPOSITIVO_NULO);

        this.validarNumeroDispositivo(dispositivoVO.getNumeroDispositivo());

        Dispositivo dispositivo = this.guardarDispositivo(dispositivoVO);

        return dispositivoVO.setId(dispositivo.getId())
                .setEstado(dispositivo.getEstado())
                .setFechaCreacion(dispositivo.getFechaCreacion());
    }

    private void validarNumeroDispositivo(String numeroDispositivo) {

        if(Long.compare(0, this.dispositivoRepositorio.countByNumeroDispositivo(numeroDispositivo)) != 0) {

            TeleasistenciaException.throwException(TipoError.NUMERO_DISPOSITIVO_REPETIDO.build());
        }
    }

    private Dispositivo guardarDispositivo(DispositivoVO dispositivoVO) {

        return this.dispositivoRepositorio
                .save(
                    this.mapper.map(dispositivoVO, Dispositivo.class)
                        .setEstado(TeleasistenciaConstantes.Estado.ACT.ordinal())
                        .setFechaCreacion(new Date())
                );
    }
}
