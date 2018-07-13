package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.teleasistencia.adm.personas.modelo.Persona;

public interface IPersonaRepositorio extends CrudRepository<Persona, Integer> {

    long countByCedula(String cedula);

    @Query("SELECT new java.lang.Integer(p.id) FROM Persona p where p.cedula = :cedula")
    Integer findIdByCedula(@Param("cedula") String cedula);
}
