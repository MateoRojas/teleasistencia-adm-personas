package org.teleasistencia.adm.personas.servicio;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.teleasistencia.adm.personas.persistencia.IPersonaRepositorio;

@RunWith(MockitoJUnitRunner.class)
public class TestPersonaServicio {

    @Mock
    private IPersonaRepositorio personaRepositorio;

    @InjectMocks
    private PersonaServicio personaServicio;

    @Test
    public void crearPersona() {


    }
}
