package org.teleasistencia.adm.personas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.teleasistencia.adm.personas.excepcion.TipoError;
import org.teleasistencia.adm.personas.persistencia.CatalogoRepositorio;
import org.teleasistencia.adm.personas.vo.respuestas.CatalogoVO;

import java.util.Collection;

@Service
@Transactional
public class CatalogoServicio {

    @Autowired
    private ValidacionServicio validacionServicio;

    @Autowired
    private CatalogoRepositorio catalogoRepositorio;

    public Collection<CatalogoVO> buscarCatalogoPorAbreviacionCategoria(String abreviacion) {

        this.validacionServicio.validarBlankString(abreviacion, TipoError.ABREVIACION_VACIA);

        return this.catalogoRepositorio.findByAbreviacionCategoria(abreviacion);
    }
}
