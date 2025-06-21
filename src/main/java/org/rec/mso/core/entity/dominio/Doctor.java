package org.rec.mso.core.entity.dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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