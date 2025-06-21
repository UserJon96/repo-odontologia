package org.rec.mso.core.adapter.out.persistence;

import org.rec.mso.core.entity.dominio.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadesRepository extends JpaRepository<Especialidade, Integer> {
}