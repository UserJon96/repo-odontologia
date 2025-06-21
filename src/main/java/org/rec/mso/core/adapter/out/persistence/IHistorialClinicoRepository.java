package org.rec.mso.core.adapter.out.persistence;

import org.rec.mso.core.entity.dominio.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistorialClinicoRepository extends JpaRepository<HistorialClinico, Integer> {
    List<HistorialClinico> findByPaciente_IdPacienteAndEstado (Integer pacienteId, String estado);
    List<HistorialClinico> findByEstado(String estado);


}