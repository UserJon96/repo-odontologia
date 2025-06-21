package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cita_tooth")
@Data
public class CitaTooth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCitaTooth;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "id_tooth", nullable = false)
    private Tooth tooth;

    private String estado;
}
