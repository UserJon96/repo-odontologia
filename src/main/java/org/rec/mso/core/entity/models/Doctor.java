package org.rec.mso.core.entity.odontologia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.rec.mso.core.entity.models.Persona;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
@Entity
@Table(name = "Doctor")
public class Doctor{

    @Id
    @Column(name = "id_doctor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDoctor;

    @Column(name = "numero_colegiado", unique = true, nullable = false, length = 50)
    private String numeroColegiado;

    @ManyToOne
    @JoinColumn(name = "id_especialidad", nullable = false)
    private Especialidade especialidad;

    @OneToOne
    @JoinColumn(name = "idpersona", referencedColumnName = "id")
    private Persona persona;

    public Doctor() {
    }
}