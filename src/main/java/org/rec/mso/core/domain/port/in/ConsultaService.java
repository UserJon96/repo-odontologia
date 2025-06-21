package org.rec.mso.core.domain.port.in;
import lombok.NonNull;
import org.rec.mso.core.entity.dominio.RegistrosConsulta;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface ConsultaService {
    List<RegistrosConsulta> getAll();

    RegistrosConsulta getForId(@NonNull Integer id);

    RsTrxService register(RegistrosConsulta body);

    RsTrxService update(RegistrosConsulta body);
}
