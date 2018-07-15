package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.teleasistencia.adm.personas.modelo.Persona;

public interface IPersonaRepositorio extends PagingAndSortingRepository<Persona, Integer>, QueryByExampleExecutor<Persona> {

    long countByCedula(String cedula);

    @Query("SELECT new java.lang.Integer(p.id) FROM Persona p where p.cedula = :cedula")
    Integer findIdByCedula(@Param("cedula") String cedula);
}
