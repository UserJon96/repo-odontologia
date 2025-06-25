package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "antecedentes_paciente")
@Data
public class AntecedentePaciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_historial", nullable = false)
    private HistorialClinico historial;

    @Column(name = "tratamiento_medico")
    private Boolean tratamientoMedico;

    @Column(name = "propenso_hemorragia")
    private Boolean propensoHemorragia;

    @Column(name = "alergia_medica", length = 50, nullable = false)
    private String alergiaMedica;

    @Column(name = "hipertenso")
    private Boolean hipertenso;

    @Column(name = "diabetico")
    private Boolean diabetico;

    @Column(name = "enfermedades_hereditarias", length = 150)
    private String enfermedadesHereditarias;

    @Column(name = "cirujias_previas")
    private Boolean cirujiasPrevias;

    @Column(name = "tipo_habito", length = 50)
    private String tipoHabito;

    @Column(name = "condiciones_embarazo")
    private Boolean condicionesEmbarazo;

    @Column(name = "frecuencia_cepillado", length = 50)
    private String frecuenciaCepillado;
}
