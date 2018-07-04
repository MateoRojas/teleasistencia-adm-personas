package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.teleasistencia.adm.personas.modelo.Entidad;

public interface IEntidadRepositorio extends CrudRepository<Entidad, Integer> {

    long countByNombreContaining(String nombre);
}
