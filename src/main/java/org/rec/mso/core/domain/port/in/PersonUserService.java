package org.rec.mso.core.domain.port.in;

import lombok.NonNull;
import org.rec.mso.core.entity.dominio.Usuario;
import org.rec.mso.core.utils.RsTrxService;

import java.util.List;

public interface PersonUserService {
    List<Usuario> getAllUsers();

    Usuario getPersonForId(@NonNull Integer id);

    Usuario getPersonForIdPerson(@NonNull Integer id);

    RsTrxService registerUser(Usuario body);

    RsTrxService updateUser(Usuario body);

}
