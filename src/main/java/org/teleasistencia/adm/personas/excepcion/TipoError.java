package org.teleasistencia.adm.personas.excepcion;

import lombok.Getter;

import javax.validation.Payload;

@Getter
public enum TipoError implements Payload {

    INESPERADO(1, CategoriaError.ERROR_SERVIDOR, "Error inesperado", "Error inesperado, por favor contacte al administrador del sistema"),
    VALIDACION(2, CategoriaError.REQUERIMIENTO_INVALIDO, "Error al validar los campos", "%s"),
    PERONSA_NULA(3, CategoriaError.REQUERIMIENTO_INVALIDO, "Error de objeto nulo", "La persona enviada no puede ser nula"),
    PERSONA_CEDULA_REPETIDA(4, CategoriaError.REQUERIMIENTO_INVALIDO, "Error al guardar la persona", "Ya existe una persona con el mismo numero de cedula");

    private CategoriaError categoria;

    private String mensaje;

    private String descripcion;

    private Integer numero;

    TipoError(Integer numero, CategoriaError categoria, String mensaje, String descripcion) {

        this.numero = numero;
        this.mensaje = mensaje;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Error build(Object... args) {

        return new Error(this, args);
    }

    public Error build() {

        return new Error(this);
    }
}
