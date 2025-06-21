package org.rec.mso.core.domain.port.in;

import lombok.NonNull;

import org.rec.mso.core.entity.dominio.Cita;
import org.rec.mso.core.utils.RsTrxService;
import java.util.List;

public interface CitaService {
    List<Cita> getAll();

    Cita getForId(@NonNull Integer id);

    List<Cita> getNotificacionDoctorId(@NonNull Integer id);

    RsTrxService register(Cita body);

    RsTrxService update(Cita body);
}
