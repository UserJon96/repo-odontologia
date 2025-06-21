package org.rec.mso.core.adapter.in.web;

import jakarta.validation.Valid;
import org.rec.mso.core.entity.dto.AuthenticationRequest;
import org.rec.mso.core.entity.dto.AuthenticationResponse;
import org.rec.mso.core.domain.port.in.AuthenticationService;
import org.rec.mso.core.utils.RsTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/OTC/authentication")
public class AuthenticationController {
    @Autowired
    private AuthenticationService service;
    @PostMapping("/login")
    public ResponseEntity<RsTrxService> login(@RequestBody @Valid AuthenticationRequest request){
        return ResponseEntity.ok(service.login(request));

    }
    @PostMapping("/sign")
    public ResponseEntity<AuthenticationResponse> sign(@RequestBody @Valid AuthenticationRequest request){
        return ResponseEntity.ok(service.sign(request));
    }

}
