package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.teleasistencia.adm.personas.modelo.Catalogo;
import org.teleasistencia.adm.personas.vo.respuestas.CatalogoVO;

import java.util.Collection;

public interface ICatalogoRepositorio extends CrudRepository<Catalogo, Integer> {

    @Query("SELECT new org.teleasistencia.adm.personas.vo.respuestas.CatalogoVO(c.id, c.abreviacion, c.nombre, c.descripcion) " +
            "FROM Catalogo c " +
            "INNER JOIN c.categoria ca " +
            "WHERE ca.abreviacion = :abreviacion")
    Collection<CatalogoVO> findByAbreviacionCategoria(@Param("abreviacion") String abreviacion);
}
