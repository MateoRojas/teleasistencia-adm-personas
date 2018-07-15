package org.teleasistencia.adm.personas.servicio;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teleasistencia.adm.personas.comun.TeleasistenciaConstantes;
import org.teleasistencia.adm.personas.excepcion.TeleasistenciaException;
import org.teleasistencia.adm.personas.excepcion.TipoError;
import org.teleasistencia.adm.personas.modelo.Persona;
import org.teleasistencia.adm.personas.persistencia.IPersonaRepositorio;
import org.teleasistencia.adm.personas.vo.consultas.PersonaVO;
import org.teleasistencia.adm.personas.vo.respuestas.ResultadoPaginado;

import java.util.Date;

import static org.teleasistencia.adm.personas.comun.TeleasistenciaConstantes.ESPACIO;

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

        this.validarCedulaCreacion(personaVO.getCedula());

        Persona persona = this.guardarPersona(personaVO);

        return personaVO.setId(persona.getId())
                .setFechaCreacion(persona.getFechaCreacion())
                .setEstado(persona.getEstado());
    }

    private void validarCedulaCreacion(String cedula) {

        if(Long.compare(0, this.personaRepositorio.countByCedula(cedula)) != 0) {

            TeleasistenciaException.throwException(TipoError.PERSONA_CEDULA_REPETIDA.build());
        }
    }

    public PersonaVO actualizaPersonaPorId(PersonaVO personaVO) {

        this.validarPersonaActualizacion(personaVO);

        this.actualizarpersona(personaVO);

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

    private Persona actualizarpersona(PersonaVO personaVO) {

        return this.personaRepositorio
                .save(
                    this.mapper.map(personaVO, Persona.class)
                    .setNombreCompleto(this.obtenerNombreCompleto(personaVO))
                );
    }

    private Persona guardarPersona(PersonaVO personaVO) {

        return this.personaRepositorio
                .save(
                    this.mapper.map(personaVO, Persona.class)
                    .setNombreCompleto(this.obtenerNombreCompleto(personaVO))
                    .setEstado(TeleasistenciaConstantes.Estado.ACT.ordinal())
                    .setFechaCreacion(new Date())
                );
    }

    private String obtenerNombreCompleto(PersonaVO personaVO) {

        StringBuilder nombre = new StringBuilder();

        if(personaVO.getPrimerNombre() != null) nombre.append(personaVO.getPrimerNombre()).append(ESPACIO);
        if(personaVO.getSegundoNombre() != null) nombre.append(personaVO.getSegundoNombre()).append(ESPACIO);
        if(personaVO.getPrimerApellido() != null) nombre.append(personaVO.getPrimerApellido()).append(ESPACIO);
        if(personaVO.getSegundoApellido() != null) nombre.append(personaVO.getSegundoApellido()).append(ESPACIO);

        return nombre.toString();
    }

    public ResultadoPaginado<PersonaVO> buscarPersonaPorFiltros(String cedula, String nombre, Integer pagina, Integer maximo) {

        this.validarBuscarPersonaPorFiltros(pagina, maximo);

        Persona busqueda = this.armarPersonaFiltrosBusqueda(cedula, nombre);
        ExampleMatcher matcher = this.armarCondicionesPersonaBusquedaFiltros();

        return this.armarResultadoPaginado(this.obtenerPersonaPorFiltrosPaginado(busqueda, matcher, pagina, maximo));
    }

    private Page<PersonaVO> obtenerPersonaPorFiltrosPaginado(Persona busqueda, ExampleMatcher matcher, Integer pagina, Integer maximo) {

        return this.personaRepositorio.findAll(Example.of(busqueda, matcher), PageRequest.of(pagina, maximo))
                .map(persona -> this.mapper.map(persona, PersonaVO.class));
    }

    private <T> ResultadoPaginado<T> armarResultadoPaginado(Page<T> resultado) {

        return new ResultadoPaginado<T>()
                .setDatos(resultado.getContent())
                .setMaximoPagina(resultado.getSize())
                .setNumeroPagina(resultado.getNumber())
                .setTotalPaginas(resultado.getTotalPages())
                .setTotalElementos(Math.toIntExact(resultado.getTotalElements()));
    }

    private void validarBuscarPersonaPorFiltros(Integer pagina, Integer maximo) {

        this.validacionServicio.validarMayorIgualQue(pagina, 0, TipoError.NUMERO_PAGINA_INVALIDO);
        this.validacionServicio.validarMayorQue(maximo, 0, TipoError.MAXIMO_PAGINA_INVALIDO);

    }

    private ExampleMatcher armarCondicionesPersonaBusquedaFiltros() {

        return ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withIgnoreNullValues()
                .withMatcher("cedula", match -> match.contains())
                .withMatcher("nombreCompleto", match -> match.contains());
    }

    private Persona armarPersonaFiltrosBusqueda(String cedula, String nombre) {

        Persona persona = new Persona();

        if(cedula != null && !cedula.trim().isEmpty()) persona.setCedula(cedula);
        if(nombre != null && !nombre.trim().isEmpty()) persona.setNombreCompleto(nombre);

        return persona;
    }
}
