package org.rec.mso.core.entity.odontologia;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "archivos_paciente")
public class ArchivoPaciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_cita", unique = true, nullable = false)
    private Cita cita;

    @Column(name = "nombre_archivo")
    private String nombreArchivo;

    //@Lob
    @Column(name = "file_data", columnDefinition = "BYTEA", nullable = false)
    private byte[] fileData;

    @Column(name = "fecha_subida")
    private LocalDateTime fechaSubida = LocalDateTime.now();
}
