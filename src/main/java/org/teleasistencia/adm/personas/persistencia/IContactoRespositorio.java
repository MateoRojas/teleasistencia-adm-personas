package org.teleasistencia.adm.personas.persistencia;

import org.springframework.data.repository.CrudRepository;
import org.teleasistencia.adm.personas.modelo.Contacto;
import org.teleasistencia.adm.personas.modelo.id.ContactoID;

public interface IContactoRespositorio extends CrudRepository<Contacto, ContactoID> {

//    @Query("SELECT new org.teleasistencia.adm.personas.vo.respuestas.VistaContactoVO(con.idPersona, con.idDispositivo," +
//            "per.primerNombre, per.primerApellido, per.cedula, par.nombre, con.distancia, per.telefonoPrincipal, per.callePrincipal" +
//            "per.numeracionDomicilio) " +
//            "FROM Contacto con " +
//            "INNER JOIN c.persona per " +
//            "INNER JOIN c.parentesco par ")
    //Collection<VistaContactoVO> findByIdDispositivo(Integer idDispositivo);
}
