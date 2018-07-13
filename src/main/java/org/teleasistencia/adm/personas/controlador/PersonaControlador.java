package org.teleasistencia.adm.personas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teleasistencia.adm.personas.servicio.PersonaServicio;
import org.teleasistencia.adm.personas.vo.consultas.PersonaVO;

@RestController
@RequestMapping("/personas")
public class PersonaControlador {

    @Autowired
    private PersonaServicio personaServicio;

    @PostMapping
    public ResponseEntity<PersonaVO> crearPersona(@RequestBody PersonaVO personaVO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.personaServicio.crearPersona(personaVO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonaVO> buscarPersonaPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(this.personaServicio.buscarPersonaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaVO> actualizarPersonaPorId(@PathVariable Integer id, @RequestBody PersonaVO persona) {

        return ResponseEntity.ok(this.personaServicio.actualizaPersonaPorId(persona));
    }
}
