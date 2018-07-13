package org.teleasistencia.adm.personas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.teleasistencia.adm.personas.servicio.DispositivoServicio;
import org.teleasistencia.adm.personas.vo.consultas.ContactoVO;
import org.teleasistencia.adm.personas.vo.consultas.DispositivoVO;
import org.teleasistencia.adm.personas.vo.respuestas.VistaContactoVO;

import java.util.Collection;

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

    @PostMapping("/contactos")
    public ResponseEntity<ContactoVO> agregarContacto(@RequestBody ContactoVO contactoVO) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.dispositivoServicio.agregarContacto(contactoVO));
    }

    @GetMapping("{id}/contactos")
    public ResponseEntity<Collection<VistaContactoVO>> buscarContactos(@PathVariable Integer id) {

        return ResponseEntity
                .ok(this.dispositivoServicio.buscarContactos(id));
    }
}
