package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Integer idServicio;

    @Column(name = "nombre", unique = true, nullable = false, length = 100)
    private String nombre;

    @Column(name = "costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(length = 1)
    private String estado = "A";

   public Servicio() {
    }

    public Servicio(String nombre, BigDecimal costo, String estado) {
        this.nombre = nombre;
        this.costo = costo;
        this.estado = estado;
    }
}