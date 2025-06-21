package org.rec.mso.core.application.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.dominio.ArchivoPaciente;
import org.rec.mso.core.exeptions.BusinessException;
import org.rec.mso.core.exeptions.NotFoundProductExeptions;
import org.rec.mso.core.adapter.out.persistence.IArchivoRepository;
import org.rec.mso.core.domain.port.in.ArchivoService;
import org.rec.mso.core.utils.Message;
import org.rec.mso.core.utils.RsTrxService;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Log4j2
@Service
public class ArchivoServiceImpl implements ArchivoService {

    @Autowired
    private IArchivoRepository repository;

    @Override
    public List<ArchivoPaciente> getAll() {
        return repository.findAll();
    }

    @Override
    public ArchivoPaciente getForId(@NonNull Integer id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Override
    public RsTrxService register(ArchivoPaciente body, MultipartFile file) {
        try {
            if (file.isEmpty()) {
                new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, "El archivo está vacío.");
                throw new Exception("El archivo está vacío.");
            }
            String fileName = file.getOriginalFilename();
            byte[] fileData  = file.getBytes();
            body.setNombreArchivo(fileName);
            body.setFileData(fileData);

            repository.save(body);
            log.info("Registro exitoso.");
            return new RsTrxService(StatusCode.SUCCESS, 0, "OK");
        } catch (Exception e) {
            log.error("Error al registrar: {}", e.getMessage());
            new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage()));
        }
    }

    @Override
    public RsTrxService update(ArchivoPaciente body) {
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