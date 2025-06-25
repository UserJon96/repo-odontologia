package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cita_Procedimiento_Dental")
@Data
public class CitaProcedimientoDental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita_procedimiento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cita", nullable = false)
    private Cita cita;

    @Column(name = "tipo_procedimiento", nullable = false, length = 30)
    private String tipoProcedimiento;

    @Column(name = "id_referencia", nullable = false)
    private Long idReferencia;

    @Column(name = "estado", length = 20)
    private String estado;
}
