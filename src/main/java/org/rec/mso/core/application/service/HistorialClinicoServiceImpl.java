package org.rec.mso.core.application.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.dominio.HistorialClinico;
import org.rec.mso.core.entity.dominio.Paciente;
import org.rec.mso.core.exeptions.BusinessException;
import org.rec.mso.core.adapter.out.persistence.IHistorialClinicoRepository;
import org.rec.mso.core.adapter.out.persistence.IPacienteRepository;
import org.rec.mso.core.domain.port.in.HistorialClinicoService;
import org.rec.mso.core.utils.RsTrxService;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class HistorialClinicoServiceImpl implements HistorialClinicoService {

    @Autowired
    private IHistorialClinicoRepository repository;

    @Autowired
    private IPacienteRepository h_repository;

    @Transactional(readOnly = true)
    @Override
    public List<HistorialClinico> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public List<HistorialClinico> getForId(@NonNull Integer pacienteId) {
        Optional<Paciente> model = h_repository.findByPersonaId(pacienteId);
        return repository.findByPaciente_IdPacienteAndEstado(model.get().getIdPaciente(), "A");
    }

    @Transactional
    @Override
    public RsTrxService register(HistorialClinico body) {
        try {

            Optional<Paciente> model = h_repository.findByPersonaId(body.getPaciente().getIdPaciente());
            body.setPaciente(model.get());
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
    public RsTrxService update(HistorialClinico body) {
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