package org.teleasistencia.adm.personas.excepcion;

import lombok.Getter;

import javax.validation.Payload;

@Getter
public enum TipoError implements Payload {

    INESPERADO(CategoriaError.ERROR_SERVIDOR, "Error inesperado", "Error inesperado, por favor contacte al administrador del sistema"),
    VALIDACION(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al validar los campos", "%s"),
    PERONSA_NULA(CategoriaError.REQUERIMIENTO_INVALIDO, "Error de objeto nulo", "La persona enviada no puede ser nula"),
    PERSONA_CEDULA_REPETIDA(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al guardar la persona", "Ya existe una persona con el mismo numero de cedula"),
    DISPOSITIVO_NULO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error de objeto nulo", "El dispositivo enviado no puede ser nulo"),
    NUMERO_DISPOSITIVO_REPETIDO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al guardar el dispositivo", "Ya existe un dispositivo con el mismo numero"),
    ENTIDAD_NULA(CategoriaError.REQUERIMIENTO_INVALIDO, "Error de objeto nulo", "La entidad enviada no puede ser nula"),
    NOMBRE_ENTIDAD_REPETIDO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al guardar la entidad", "Ya existe una entidad con el mismo nombre"),
    ABREVIACION_VACIA(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al buscar en catalogo", "La abreviacion no puede estar vacia"),
    CONTACTO_NULO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error de objeto nulo", "El contacto no puede ser nulo"),
    ID_DISPOSITIVO_NULO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al buscar los contactos", "El id del dispositivo no puede ser nulo"),
    PERSONA_NO_ENCONTRADA(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al buscar la persona", "No se encontro ninguna persona asociada al id provisto"),
    PERSONA_ID_NULO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error al actulizar la persona", "La persona no puede tener un id vacio"),
    NUMERO_PAGINA_INVALIDO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error realizar la busqueda", "El numero de página no es valido"),
    MAXIMO_PAGINA_INVALIDO(CategoriaError.REQUERIMIENTO_INVALIDO, "Error realizar la busqueda", "El maximo de página no es valido");

    private CategoriaError categoria;

    private String mensaje;

    private String descripcion;

    private Integer numero;

    TipoError(CategoriaError categoria, String mensaje, String descripcion) {

        this.numero = this.ordinal();
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
