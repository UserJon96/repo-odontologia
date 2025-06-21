package org.rec.mso.core.domain.port.in;

import lombok.NonNull;
import org.rec.mso.core.entity.dominio.ArchivoPaciente;
import org.rec.mso.core.utils.RsTrxService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ArchivoService {
    List<ArchivoPaciente> getAll();

    ArchivoPaciente getForId(@NonNull Integer id);

    RsTrxService register(ArchivoPaciente body, MultipartFile file);

    RsTrxService update(ArchivoPaciente body);
}
