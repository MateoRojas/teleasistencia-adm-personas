package org.teleasistencia.adm.personas.excepcion;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Error {

    private TipoError tipoError;

    private Object[] arguments;

    public Error(TipoError tipoError, Object... arguments) {

        this.tipoError = tipoError;
        this.arguments = arguments;
    }

    public Integer numero() {
        return this.tipoError.getNumero();
    }

    public String descripcion() {
        return String.format(this.tipoError.getDescripcion(), this.arguments);
    }

    public String mensaje() {
        return this.tipoError.getMensaje();
    }

    public CategoriaError categoria() {
        return this.tipoError.getCategoria();
    }
}
