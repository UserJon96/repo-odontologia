package org.rec.mso.core.application.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.dominio.Pago;
import org.rec.mso.core.exeptions.BusinessException;
import org.rec.mso.core.exeptions.NotFoundProductExeptions;
import org.rec.mso.core.adapter.out.persistence.ICitaRepository;
import org.rec.mso.core.adapter.out.persistence.IPagoRepository;
import org.rec.mso.core.domain.port.in.PagoService;
import org.rec.mso.core.utils.Message;
import org.rec.mso.core.utils.RsTrxService;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Log4j2
@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private IPagoRepository repository;

    @Autowired
    private ICitaRepository c_repository;

    @Transactional(readOnly = true)
    @Override
    public List<Pago> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Pago getForId(@NonNull Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public RsTrxService register(Pago body) {
        try {
            body.setFechaPago(LocalDateTime.now());
            repository.save(body);

            c_repository.save(body.getCita());
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
    public RsTrxService update(Pago body) {
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
