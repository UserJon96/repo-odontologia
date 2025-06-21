package org.rec.mso.core.adapter.in.web;

import org.rec.mso.core.domain.port.in.TratamientosService;
import org.rec.mso.core.entity.dominio.Tratamiento;
import org.rec.mso.core.utils.RsTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/tratamiento")
public class TratamientoController {

    @Autowired
    private TratamientosService service;

    @GetMapping("/consult")
    public ResponseEntity<List<Tratamiento>> getAll(){
        return ResponseEntity.ok((service.getAll()));
    }

    @GetMapping("/consultId/{id}")
    public ResponseEntity<Tratamiento> getId(@PathVariable Integer id){
        return ResponseEntity.ok(service.getForId(id));
    }

    @PostMapping("/register")
    public ResponseEntity<RsTrxService> insert(@RequestBody Tratamiento body){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.register(body));
    }

    @PutMapping("/update")
    public ResponseEntity<RsTrxService> update(@RequestBody Tratamiento body){
        return ResponseEntity.ok(service.update(body));
    }
}