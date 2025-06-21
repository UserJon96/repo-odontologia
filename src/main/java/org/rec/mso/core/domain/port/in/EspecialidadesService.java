package org.rec.mso.core.domain.port.in;
import lombok.NonNull;
import org.rec.mso.core.entity.dominio.Especialidade;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface EspecialidadesService {
    List<Especialidade> getAll();

    Especialidade getForId(@NonNull Integer id);

    RsTrxService register(Especialidade body);

    RsTrxService update(Especialidade body);
}
