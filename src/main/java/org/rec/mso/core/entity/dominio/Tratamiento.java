package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Tratamientos")
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tratamiento")
    private Integer idTratamiento;

    @Column(name = "nombre", unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(name = "costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 1)
    private String estado = "A";

   public Tratamiento() {
    }

    public Tratamiento(String nombre, BigDecimal costo, String estado) {
        this.nombre = nombre;
        this.costo = costo;
        this.estado = estado;
    }
}