package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Accessors(chain = true)
public class Dispositivo {

    // Id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDispositivo")
    private Integer id;

    // Atributos

    private Double latitud;

    private Double longitud;

    private String numeroDispositivo;

    private String callePrincipal;

    private String calleSecundaria;

    private String numeracionDomicilio;

    private String referencia;

    private String telefonoPrincipal;

    private String rutaImagenCasa;

    private String rutaImagenMapa;

    private Integer estado;

    // Relaciones

    @OneToMany(mappedBy = "dispositivo")
    private Collection<EntidadDispositivo> entidadDispositivoCol;

    @OneToMany(mappedBy = "dispositivo")
    private Collection<Beneficiario> beneficiarioCol;

    @OneToMany(mappedBy = "dispositivo")
    private Collection<Contacto> contactoCol;
}
