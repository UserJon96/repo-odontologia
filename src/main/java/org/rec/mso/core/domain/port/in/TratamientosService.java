package org.rec.mso.core.domain.port.in;

import lombok.NonNull;
import org.rec.mso.core.entity.dominio.Tratamiento;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface TratamientosService {
    List<Tratamiento> getAll();

    Tratamiento getForId(@NonNull Integer id);

    RsTrxService register(Tratamiento body);

    RsTrxService update(Tratamiento body);
}
