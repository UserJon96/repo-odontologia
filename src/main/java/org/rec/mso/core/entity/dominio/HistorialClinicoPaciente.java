package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "historial_clinico")
@Data
public class HistorialClinicoPaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id;

    @Column(name = "id_paciente", nullable = false, unique = true)
    private Long idPaciente;

    @Column(name = "fecha_apertura")
    private LocalDate fechaApertura = LocalDate.now();

    @Column(name = "estado", length = 1)
    private String estado = "A";

    @OneToOne(mappedBy = "historial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AntecedentePaciente antecedente;
}
