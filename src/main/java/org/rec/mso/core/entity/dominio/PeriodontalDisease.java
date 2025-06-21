package org.rec.mso.core.entity.dominio;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "periodontal_disease")
public class PeriodontalDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periodontal_disease", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "enfermedad", length = 20)
    private String enfermedad;

    @Size(max = 20)
    @Column(name = "oclusion", length = 20)
    private String oclusion;

    @Size(max = 20)
    @Column(name = "fluorosis", length = 20)
    private String fluorosis;

}