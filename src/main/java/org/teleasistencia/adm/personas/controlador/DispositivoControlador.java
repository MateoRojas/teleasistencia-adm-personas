package org.teleasistencia.adm.personas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teleasistencia.adm.personas.servicio.DispositivoServicio;
import org.teleasistencia.adm.personas.vo.consultas.DispositivoVO;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoControlador {

    @Autowired
    private DispositivoServicio dispositivoServicio;

    @PostMapping
    public ResponseEntity<DispositivoVO> crearDispositivo(@RequestBody DispositivoVO dispositivoVO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.dispositivoServicio.crearDispositivo(dispositivoVO));
    }
}
