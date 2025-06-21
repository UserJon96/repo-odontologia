package org.rec.mso.core.application.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.dominio.Paciente;
import org.rec.mso.core.exeptions.BusinessException;
import org.rec.mso.core.exeptions.NotFoundProductExeptions;
import org.rec.mso.core.adapter.out.persistence.IPacienteRepository;
import org.rec.mso.core.domain.port.in.PacienteService;
import org.rec.mso.core.utils.Message;
import org.rec.mso.core.utils.RsTrxService;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Log4j2
@Service
public class PacienteServiceImpl  implements PacienteService {

    @Autowired
    private IPacienteRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente getPacienteForCedulaPerson(@NonNull String cedula) {
        return repository.findByPersonaCedula(cedula)
                .orElseThrow(() -> new NotFoundProductExeptions(
                        Message.NOT_FOUND,
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente getPacienteForIdPerson(@NonNull Integer id) {
        return repository.findByPersonaId(id)
                .orElseThrow(() -> new NotFoundProductExeptions(
                        Message.NOT_FOUND,
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND));
    }


    @Transactional(readOnly = true)
    @Override
    public Paciente getForId(@NonNull Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public RsTrxService register(Paciente body) {
        try {
            repository.save(body);
            log.info("Registro exitoso.");
            return new RsTrxService(StatusCode.SUCCESS, 0, "OK");
        } catch (Exception e) {
            log.error("Error al registrar: {}", e.getMessage());
            new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage()));
        }
    }

    @Transactional
    @Override
    public RsTrxService update(Paciente body) {
        try {
            repository.save(body);
            log.info("Actualización exitosa.");
            return new RsTrxService(StatusCode.SUCCESS, 0, "Actualización exitosa.");
        } catch (Exception e) {
            log.error("Error al actualizar: {}", e.getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getMessage()));
        }
    }
}