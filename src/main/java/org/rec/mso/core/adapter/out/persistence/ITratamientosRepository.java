package org.rec.mso.core.adapter.out.persistence;

import org.rec.mso.core.entity.dominio.Tratamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITratamientosRepository extends JpaRepository<Tratamiento, Integer> {
}