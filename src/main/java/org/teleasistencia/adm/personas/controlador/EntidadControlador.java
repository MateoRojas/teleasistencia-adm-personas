package org.teleasistencia.adm.personas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teleasistencia.adm.personas.servicio.EntidadServicio;
import org.teleasistencia.adm.personas.vo.consultas.EntidadVO;

@RestController
@RequestMapping("/entidades")
public class EntidadControlador {

    @Autowired
    private EntidadServicio entidadServicio;

    @PostMapping
    public ResponseEntity<EntidadVO> crearEntidad(@RequestBody EntidadVO entidadVO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.entidadServicio.crearEntidad(entidadVO));
    }
}
