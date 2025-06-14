package org.rec.mso.core.entity.odontologia;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cita_toothpiece")
@Data
public class CitaToothPiece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCitaToothPiece;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @ManyToOne
    @JoinColumn(name = "id_tooth_piece", nullable = false)
    private ToothPiece toothPiece;
}
