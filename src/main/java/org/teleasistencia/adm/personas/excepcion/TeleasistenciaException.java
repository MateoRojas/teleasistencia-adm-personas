package org.teleasistencia.adm.personas.excepcion;

import lombok.Getter;

import java.util.Objects;

@Getter
public class TeleasistenciaException extends RuntimeException {

    private Error error;

    private TeleasistenciaException(Throwable causa, Error error) {

        super(error.toString(), causa);
        this.error = error;
    }

    public void throwException() {
        throw this;
    }

    public static void throwException(Error error) {

        TeleasistenciaException.of(error).throwException();
    }

    public static TeleasistenciaException of(Error error) {
        return new Builder(error).build();
    }

    private static class Builder {

        private Throwable causa;
        private Error error;

        public Builder(Error error) {
            this.error = Objects.requireNonNull(error);
        }

        public Builder causa(Throwable causa) {

            this.causa = causa;
            return this;
        }

        public void throwException() {
            this.build().throwException();
        }

        private TeleasistenciaException build() {
            return new TeleasistenciaException(this.causa, this.error);
        }
    }
}
