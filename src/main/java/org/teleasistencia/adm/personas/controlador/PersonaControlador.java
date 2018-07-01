package org.teleasistencia.adm.personas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teleasistencia.adm.personas.servicio.PersonaServicio;
import org.teleasistencia.adm.personas.vo.consultas.PersonaVO;
import org.teleasistencia.adm.personas.vo.respuestas.RecursoCreadoVO;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    @Autowired
    private PersonaServicio personaServicio;

    @PostMapping
    public ResponseEntity<RecursoCreadoVO<Integer, PersonaVO>> crearPersona(@RequestBody PersonaVO persona) {

        RecursoCreadoVO<Integer, PersonaVO> personaCreada = this.personaServicio.crearPersona(persona);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(personaCreada);
    }
}
