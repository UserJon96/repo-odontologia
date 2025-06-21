package org.rec.mso.core.domain.port.in;
import lombok.NonNull;
import org.rec.mso.core.entity.dominio.Paciente;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface PacienteService {
    List<Paciente> getAll();

    Paciente getPacienteForCedulaPerson(@NonNull String cedula);

    Paciente getPacienteForIdPerson(@NonNull Integer id);



    Paciente getForId(@NonNull Integer id);

    RsTrxService register(Paciente body);

    RsTrxService update(Paciente body);
}
