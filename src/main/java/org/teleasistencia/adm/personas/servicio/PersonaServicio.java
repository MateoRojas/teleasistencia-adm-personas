package org.teleasistencia.adm.personas.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teleasistencia.adm.personas.comun.TeleasistenciaConstantes;
import org.teleasistencia.adm.personas.excepcion.TeleasistenciaException;
import org.teleasistencia.adm.personas.excepcion.TipoError;
import org.teleasistencia.adm.personas.modelo.Persona;
import org.teleasistencia.adm.personas.persistencia.IPersonaRepositorio;
import org.teleasistencia.adm.personas.vo.consultas.PersonaVO;

import java.util.Date;

@Service
@Transactional
public class PersonaServicio {

    @Autowired
    private IPersonaRepositorio personaRepositorio;

    @Autowired
    private ValidacionServicio validacionServicio;

    @Autowired
    private ModelMapper mapper;

    public PersonaVO crearPersona(PersonaVO personaVO) {

        this.validacionServicio.validarObjeto(personaVO, TipoError.PERONSA_NULA);

        this.validarNumeroCedulaCreacion(personaVO.getCedula());

        Persona persona = this.guardarPersona(personaVO);

        return personaVO.setId(persona.getId())
                .setFechaCreacion(persona.getFechaCreacion())
                .setEstado(persona.getEstado());
    }

    private void validarNumeroCedulaCreacion(String cedula) {

        if(Long.compare(0, this.personaRepositorio.countByCedula(cedula)) != 0) {

            TeleasistenciaException.throwException(TipoError.PERSONA_CEDULA_REPETIDA.build());
        }
    }

    public PersonaVO actualizaPersonaPorId(PersonaVO personaVO) {

        this.validarPersonaActualizacion(personaVO);

        this.personaRepositorio.save(this.mapper.map(personaVO, Persona.class));

        return personaVO;
    }

    private void validarPersonaActualizacion(PersonaVO personaVO) {

        this.validacionServicio.validarNulo(personaVO.getId(), TipoError.PERSONA_ID_NULO);

        this.validacionServicio.validarObjeto(personaVO, TipoError.PERONSA_NULA);

        this.validarCedulaActualizacion(personaVO.getCedula(), personaVO.getId());
    }

    private void validarCedulaActualizacion(String cedula, Integer id) {

        Integer resultado = this.personaRepositorio.findIdByCedula(cedula);

        if(resultado != null && resultado.compareTo(id) != 0) {

            TeleasistenciaException.throwException(TipoError.PERSONA_CEDULA_REPETIDA.build());
        }

    }

    public PersonaVO buscarPersonaPorId(Integer id) {

        Persona persona = personaRepositorio
                .findById(id)
                .orElseThrow(() -> TeleasistenciaException.of(TipoError.PERSONA_NO_ENCONTRADA.build()));

        return this.mapper.map(persona, PersonaVO.class);
    }

    private Persona guardarPersona(PersonaVO personaVO) {

        return this.personaRepositorio
                .save(
                    this.mapper.map(personaVO, Persona.class)
                    .setEstado(TeleasistenciaConstantes.Estado.ACT.ordinal())
                    .setFechaCreacion(new Date())
                );
    }
}
