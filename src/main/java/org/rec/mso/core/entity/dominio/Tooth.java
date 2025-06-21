package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tooth")
public class Tooth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tooth", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "tipo", length = 20)
    private String tipo;

    @Size(max = 10)
    @Column(name = "\"position\"", length = 10)
    private String position;

    @Column(name = "quadrant")
    private Integer quadrant;

    @Size(max = 20)
    @Column(name = "estado", length = 20)
    private String estado;

}