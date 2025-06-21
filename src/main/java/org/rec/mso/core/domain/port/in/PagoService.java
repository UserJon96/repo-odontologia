package org.rec.mso.core.domain.port.in;
import lombok.NonNull;
import org.rec.mso.core.entity.dominio.Pago;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface PagoService {
    List<Pago> getAll();

    Pago getForId(@NonNull Integer id);

    RsTrxService register(Pago body);

    RsTrxService update(Pago body);
}
