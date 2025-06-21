package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Especialidades")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer idEspecialidad;

    @Column(name = "nombre_especialidad", unique = true, nullable = false, length = 100)
    private String nombreEspecialidad;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    /*@OneToMany(mappedBy = "especialidad")
    private List<Doctor> doctores;*/

   public Especialidade() {
    }

    public Especialidade(String nombreEspecialidad, String descripcion) {
        this.nombreEspecialidad = nombreEspecialidad;
        this.descripcion = descripcion;
    }

    
}