package org.rec.mso.core.application.service;

import lombok.NonNull;
import lombok.extern.log4j.Log4j2;
import org.rec.mso.core.entity.dominio.*;
import org.rec.mso.core.exeptions.BusinessException;
import org.rec.mso.core.exeptions.NotFoundProductExeptions;
import org.rec.mso.core.adapter.out.persistence.IPacienteRepository;
import org.rec.mso.core.adapter.out.persistence.IPersonaRepository;
import org.rec.mso.core.adapter.out.persistence.IUsuarioRepository;
import org.rec.mso.core.domain.port.in.PersonUserService;

import org.rec.mso.core.utils.Message;
import org.rec.mso.core.utils.RsTrxService;
import org.rec.mso.core.utils.enums.Role;
import org.rec.mso.core.utils.enums.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Log4j2
@Service
public class PersonUserServiceImpl implements PersonUserService {

    @Autowired
    private IPersonaRepository p_repository;
    @Autowired
    private IUsuarioRepository u_repository;

    @Autowired
    private IPacienteRepository pa_repository;

    @Autowired
    private PasswordEncoder encoder;

    Random random = new Random();

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getAllUsers() {
        return u_repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getPersonForId(@NonNull Integer id) {
        return u_repository.findById(id).orElseThrow(() -> new NotFoundProductExeptions(Message.NOT_FOUND, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario getPersonForIdPerson(@NonNull Integer id) {
        return u_repository.findByPersonaId(id)
                .orElseThrow(() -> new NotFoundProductExeptions(
                        Message.NOT_FOUND,
                        HttpStatus.NOT_FOUND.value(),
                        HttpStatus.NOT_FOUND));
    }

    @Transactional
    @Override
    public RsTrxService registerUser(Usuario body) {
        try {
            int secuencial = 100000 + random.nextInt(900000);

            Optional<Persona> isVerify = p_repository.findByCedula(body.getPersona().getCedula());
            Optional<Usuario> is_Verify = u_repository.findByUsername(body.getUsername());
            if(isVerify.isPresent() || is_Verify.isPresent()) {
                log.info("Registro duplicado.");
                return new RsTrxService(StatusCode.CONFLICT, 409, Message.ALREADY_EXISTS);
            }

            //Ref Insert Persona
            Persona model = p_repository.save(body.getPersona());

            //Ref Insert Usuario
            body.setPersona(model);
            body.setContrasenia(encoder.encode(body.getContrasenia()));
            body.setRole(Role.ADMINISTRATOR);
            u_repository.save(body);

            //Ref Validar si es rol paciente
            if(body.getRol().equals(Role.PACIENTE)){
                Paciente paciente = new Paciente();
                paciente.setNumeroHistoriaClinica(secuencial);
                paciente.setPersona(model);
                pa_repository.save(paciente);
            }

            log.info("Registro exitoso.");
            return new RsTrxService(StatusCode.SUCCESS, body.getPersona().getId(), "OK");
        } catch (Exception e) {
            log.error("Error al registrar: {}", e.getMessage());
            new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getCause().getMessage()));
        }
    }

    @Transactional
    @Override
    public RsTrxService updateUser(Usuario body) {
        try {
            List<Usuario> usuarios = u_repository.findAllById(List.of(body.getId()));
            Usuario usuario = mapUser(usuarios, body);

            p_repository.save(body.getPersona());
            u_repository.save(usuario);
            log.info("Actualización exitosa.");
            return new RsTrxService(StatusCode.SUCCESS, 0, "Actualización exitosa.");
        } catch (Exception e) {
            log.error("Error al actualizar: {}", e.getMessage());
            throw new BusinessException(new RsTrxService(StatusCode.INTERNAL_SERVER_ERROR, 0, e.getMessage()));
        }
    }

    public Usuario mapUser(List<Usuario> usuarios, Usuario body) {
        Usuario usuario = usuarios.iterator().hasNext()
        ? usuarios.iterator().next()
        : null;
        usuario.setUsername(body.getUsername());
        usuario.setEstado(body.getEstado());
        usuario.setRol(body.getRol());
        usuario.setContrasenia(encoder.encode(body.getContrasenia()));
        usuario.setPersona(body.getPersona());
        return usuario;
    }
}