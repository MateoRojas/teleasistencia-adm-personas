package org.teleasistencia.adm.personas.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.teleasistencia.adm.personas.servicio.CatalogoServicio;
import org.teleasistencia.adm.personas.vo.respuestas.CatalogoVO;

import java.util.Collection;

@RestController
@RequestMapping("/catalogos")
public class CatalogoControlador {

    @Autowired
    private CatalogoServicio catalogoServicio;

    @GetMapping(value = "/categoria")
    public ResponseEntity<Collection<CatalogoVO>> buscarCatalogoPorAbreviacionCategoria(
            @RequestParam(value = "abreviacion", required = false) String abreviacion) {

        return ResponseEntity
                .ok(this.catalogoServicio.buscarCatalogoPorAbreviacionCategoria(abreviacion));
    }
}
