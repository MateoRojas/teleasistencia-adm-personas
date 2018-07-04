package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.teleasistencia.adm.personas.modelo.Dispositivo;

public interface IDispositivoRepositorio extends CrudRepository<Dispositivo, Integer> {

    long countByNumeroDispositivo(String numeroDispositivo);
}
