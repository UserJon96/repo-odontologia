package org.rec.mso.core.entity.odontologia;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cita_periodontaldisease")
@Data
public class CitaPeriodontalDisease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCitaPeriodontal;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "id_periodontal_disease", nullable = false)
    private PeriodontalDisease periodontalDisease;
}

