package org.teleasistencia.adm.personas.servicio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.teleasistencia.adm.personas.persistencia.IPersonaRepositorio;
import org.teleasistencia.adm.personas.vo.consultas.PersonaVO;

import java.time.LocalDateTime;

@RunWith(MockitoJUnitRunner.class)
public class TestPersonaServicio {

    @Mock
    private IPersonaRepositorio personaRepositorio;

    @InjectMocks
    private PersonaServicio personaServicio;

    @Test
    public void crearPersona() {

        PersonaVO persona =
                new PersonaVO()
                .setIdGenero(1)
                .setPrimerNombre("Mateo")
                .setSegundoNombre(null)
                .setPrimerApellido("Rojas")
                .setSegundoApellido("Ortiz")
                .setCedula("1726020074")
                .setFechaNacimiento(LocalDateTime.of(1997, 06, 02, 0, 0))
                .setCallePrincipal("Antonio de Ulloa")
                .setCalleSecundaria("Rumipamba")
                .setNumeroDomicilio("N34-141")
                .setReferencia("Frente a Top Seg")
                .setTelefonoPrincipal("022245155")
                .setTelefonoSecundario(null)
                .setCelular("0988817485")
                .setEmail("mateo.rojas@udla.edu.ec");
    }
}
