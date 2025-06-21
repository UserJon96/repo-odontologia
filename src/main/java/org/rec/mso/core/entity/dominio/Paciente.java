package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "numero_historia_clinica", unique = true, nullable = false)
    private Integer numeroHistoriaClinica;

    @OneToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    private Persona persona;

    public Paciente() {
    }
}
