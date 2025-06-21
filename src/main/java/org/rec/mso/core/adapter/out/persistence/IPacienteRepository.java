package org.rec.mso.core.adapter.out.persistence;

import org.rec.mso.core.entity.dominio.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByPersonaCedula(String cedula);
    Optional<Paciente> findByPersonaId(Integer id);


}