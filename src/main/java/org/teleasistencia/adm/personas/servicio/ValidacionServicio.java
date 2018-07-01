package org.teleasistencia.adm.personas.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.teleasistencia.adm.personas.excepcion.TeleasistenciaException;
import org.teleasistencia.adm.personas.excepcion.TipoError;

import javax.validation.ValidatorFactory;

@Component
public class ValidacionServicio {

    @Autowired
    private ValidatorFactory validatorFactory;

    public <T> Boolean validarObjeto(T objeto, TipoError error, Class<?>... grupos) {

        this.validarNulo(objeto, error);

        validatorFactory.getValidator()
                .validate(objeto, grupos)
                .stream()
                .findFirst()
                .ifPresent(violacion ->
                        TeleasistenciaException.throwException(TipoError.VALIDACION.build(violacion.getMessage()))
                );

        return Boolean.TRUE;
    }

    public <T> Boolean validarNulo(T objeto, TipoError error) {

        if(objeto == null) {

            TeleasistenciaException.throwException(error.build());
        }

        return Boolean.TRUE;
    }
}
