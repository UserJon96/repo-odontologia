package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.CitaPeriodontalDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICitaPeriodontalDiseaseRepository extends JpaRepository<CitaPeriodontalDisease, Integer> {
}