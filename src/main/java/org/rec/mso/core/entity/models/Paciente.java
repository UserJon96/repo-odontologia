package org.rec.mso.core.entity.odontologia;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.rec.mso.core.entity.models.Persona;

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
