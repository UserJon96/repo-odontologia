package org.rec.mso.core.entity.odontologia;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tooth_piece")
public class ToothPiece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tooth_piece", nullable = false)
    private Integer id;

    @Column(name = "pieza")
    private Integer pieza;

    @Column(name = "placa")
    private Integer placa;

    @Column(name = "calculo")
    private Integer calculo;

    @Column(name = "gingivitis")
    private Integer gingivitis;

}