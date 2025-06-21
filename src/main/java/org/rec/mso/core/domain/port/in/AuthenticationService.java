package org.rec.mso.core.domain.port.in;

import org.rec.mso.core.entity.dto.AuthenticationRequest;
import org.rec.mso.core.entity.dto.AuthenticationResponse;
import org.rec.mso.core.utils.RsTrxService;

public interface AuthenticationService {
    RsTrxService login(AuthenticationRequest authentication);
    AuthenticationResponse sign(AuthenticationRequest authentication);
}
