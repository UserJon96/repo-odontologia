package org.rec.mso.core.adapter.in.web;

import org.rec.mso.core.domain.port.in.*;
import org.rec.mso.core.entity.dominio.*;
import org.rec.mso.core.utils.RsTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @Autowired
    private EspecialidadesService e_service;

    @Autowired
    private TratamientosService t_service;

    @GetMapping("/consult")
    public ResponseEntity<List<Doctor>> getAll(){
        return ResponseEntity.ok((service.getAll()));
    }

    @GetMapping("/consult/especialidades")
    public ResponseEntity<List<Especialidade>> getAllEspecialidades(){
        return ResponseEntity.ok((e_service.getAll()));
    }

    @GetMapping("/consult/tratamientos")
    public ResponseEntity<List<Tratamiento>> getAllTratamientos(){
        return ResponseEntity.ok((t_service.getAll()));
    }

    @PostMapping("/register")
    public ResponseEntity<RsTrxService> insert(@RequestBody Doctor body){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(body));
    }

}
