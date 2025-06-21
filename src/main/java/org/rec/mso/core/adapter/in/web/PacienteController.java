package org.rec.mso.core.adapter.in.web;

import org.rec.mso.core.domain.port.in.PacienteService;
import org.rec.mso.core.entity.dominio.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    @GetMapping("/consult")
    public ResponseEntity<List<Paciente>> getAll(){
        return ResponseEntity.ok((service.getAll()));
    }

    @GetMapping("/consultPacienteForCedula/{cedula}")
    public ResponseEntity<Paciente> consultPacienteForCedula(@PathVariable String cedula){
        Paciente model = service.getPacienteForCedulaPerson(cedula);
        return ResponseEntity.ok(model);
    }


}
