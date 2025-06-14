package org.rec.mso.core.entity.dto;

import lombok.Getter;
import lombok.Setter;
import org.rec.mso.core.entity.odontologia.CitaPeriodontalDisease;
import org.rec.mso.core.entity.odontologia.PeriodontalDisease;
import org.rec.mso.core.entity.odontologia.ToothPiece;
import org.rec.mso.core.entity.odontologia.Tooth;

import java.util.List;

@Getter
@Setter
public class OdontogramaDTO {
    private int id_cita;
    private int id_cita_tooth;
    private String estado;
    List<Tooth> tooth;
    List<ToothPiece> toothPiece;
    PeriodontalDisease periodontalDisease;
}
