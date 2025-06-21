package org.rec.mso.core.application.service;
import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.dominio.Cita;
import org.rec.mso.core.entity.dominio.Doctor;
import org.rec.mso.core.exeptions.*;
import org.rec.mso.core.adapter.out.persistence.ICitaRepository;
import org.rec.mso.core.adapter.out.persistence.IDoctorRepository;
import org.rec.mso.core.domain.port.in.CitaService;
import org.rec.mso.core.utils.*;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private ICitaRepository repository;

    @Autowired
    private IDoctorRepository d_repository;

    @Transactional(readOnly = true)
    @Override
    public List<Cita> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Cita> getNotificacionDoctorId(@NonNull Integer id) {
        try {
            Optional<Doctor> doc = d_repository.findByPersonaId(id);
            int idDoctor = doc.get().getIdDoctor();
            return repository.findByDoctorIdDoctor(idDoctor);
        } catch (Exception e) {
            log.warn("No se encontró un doctor con el ID de persona: {}", id);
            return new ArrayList<>();
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Cita getForId(@NonNull Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public RsTrxService register(Cita body) {
        try {
            /*Optional<Cita> isVerify = repository.findByCedula(body.getPersona().getCedula());
            if(isVerify.isPresent()) {
                log.info("Registro duplicado.");
                return new RsTrxService(StatusCode.CONFLICT, 409, Message.ALREADY_EXISTS);
            }*/

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
    public RsTrxService update(Cita body) {
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