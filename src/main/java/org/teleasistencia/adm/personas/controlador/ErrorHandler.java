package org.teleasistencia.adm.personas.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.teleasistencia.adm.personas.excepcion.CategoriaError;
import org.teleasistencia.adm.personas.excepcion.Error;
import org.teleasistencia.adm.personas.excepcion.TeleasistenciaException;
import org.teleasistencia.adm.personas.excepcion.TipoError;
import org.teleasistencia.adm.personas.vo.respuestas.ErrorVO;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(TeleasistenciaException.class)
    public ResponseEntity<ErrorVO> handle(TeleasistenciaException exception) {

        Error error = exception.getError();

        return ResponseEntity
                .status(codigoEstado(error.categoria()))
                .body(mapearError(error));
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ErrorVO> handle(Throwable exception) {

        Error error = TipoError.INESPERADO.build();

        return ResponseEntity
                .status(codigoEstado(error.categoria()))
                .body(mapearError(error));
    }

    private static ErrorVO mapearError(Error error) {

        return new ErrorVO(error.numero(), error.mensaje(), error.descripcion());
    }

    private static HttpStatus codigoEstado(CategoriaError categoria) {

        if(CategoriaError.SIN_CONTENIDO.equals(categoria)) {
            return HttpStatus.NO_CONTENT;
        }

        if(CategoriaError.REQUERIMIENTO_INVALIDO.equals(categoria)) {
            return HttpStatus.BAD_REQUEST;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
