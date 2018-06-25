package org.teleasistencia.adm.personas.modelo;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@Entity
@Accessors(chain = true)
public class Catalogo {

    // Id

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCatalogo")
    private Integer id;

    // Atributos

    private Integer idCategoria;

    private String abreviacion;

    private String nombre;

    private String descripcion;

    // Relaciones

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria", insertable = false, updatable = false)
    private Categoria categoria;
}
