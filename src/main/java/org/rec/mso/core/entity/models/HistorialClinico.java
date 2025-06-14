package org.rec.mso.core.entity.odontologia;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.List;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Historial_clinico")
public class HistorialClinico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer idHistorial;

    @Column(name = "tratamiento_medico")
    private Boolean tratamientoMedico;

    @Column(name = "propenso_hemorragia")
    private Boolean propensoHemorragia;

    @Column(name = "alergia_medica", nullable = false, length = 50)
    private String alergiaMedica;

    @Column(name = "hipertenso")
    private Boolean hipertenso;

    @Column(name = "diabetico")
    private Boolean diabetico;

    @Column(length = 1)
    private String estado = "A";

    @OneToOne
    @JoinColumn(name = "id_paciente", unique = true, nullable = false)
    private Paciente paciente;

    @Column(name = "fecha_apertura", nullable = false)
    private LocalDate fechaApertura = LocalDate.now();

    @Column(name = "enfermedades_hereditarias", nullable = false, length = 150)
    private String enfermedadesHereditarias;

    @Column(name = "cirujias_previas")
    private Boolean cirujiasPrevias;

    @Column(name = "tipo_habito", nullable = false, length = 50)
    private String tipoHabito;

    @Column(name = "condiciones_embarazo")
    private Boolean condicionesEmbarazo;

    @Column(name = "frecuencia_cepillado", nullable = false, length = 50)
    private String frecuenciaCepillado;

    //@OneToMany(mappedBy = "historialClinico", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<RegistrosConsulta> registros;

    // Constructores
    public HistorialClinico() {
    }

    public HistorialClinico(Paciente paciente) {
        this.paciente = paciente;
    }

}