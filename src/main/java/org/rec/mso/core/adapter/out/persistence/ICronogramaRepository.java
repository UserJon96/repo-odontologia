package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.Cronograma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICronogramaRepository extends JpaRepository<Cronograma, Integer> {
}