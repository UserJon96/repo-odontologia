package org.rec.mso.core.entity.odontologia;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "Cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_doctor", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_tratamiento", nullable = false)
    private Tratamiento tratamiento;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "motivo_cita", columnDefinition = "TEXT")
    private String motivoCita;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "costo", precision = 10, scale = 2)
    private BigDecimal costo;

    @Column(name = "valor_pago", precision = 10, scale = 2)
    private BigDecimal valor_pago;

    /*@OneToOne(mappedBy = "cita")
    private Pago pago;*/

    public Cita() {
    }

    public Cita(Paciente paciente, Doctor doctor, Tratamiento tratamiento,
                LocalDate fecha, LocalTime hora, String motivoCita,
                String estado, BigDecimal costo, BigDecimal valor_pago) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.tratamiento = tratamiento;
        this.fecha = fecha;
        this.hora = hora;
        this.motivoCita = motivoCita;
        this.estado = estado;
        this.costo = costo;
        this.valor_pago = valor_pago;
    }

}