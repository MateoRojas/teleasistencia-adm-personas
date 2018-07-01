package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.teleasistencia.adm.personas.modelo.Persona;

public interface IPersonaRepositorio extends CrudRepository<Persona, Integer> {

    long countByCedula(String cedula);
}
