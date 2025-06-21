package org.rec.mso.core.domain.port.in;
import lombok.NonNull;
import org.rec.mso.core.entity.dominio.HistorialClinico;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface HistorialClinicoService {
    List<HistorialClinico> getAll();

    List<HistorialClinico> getForId(@NonNull Integer pacienteId);

    RsTrxService register(HistorialClinico body);

    RsTrxService update(HistorialClinico body);
}
