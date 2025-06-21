package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.PeriodontalDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IPeriodontalDiseaseRepository extends JpaRepository<PeriodontalDisease, Integer> {
    @Query("SELECT pd FROM PeriodontalDisease pd JOIN CitaPeriodontalDisease cpd ON pd.id = cpd.periodontalDisease.id WHERE cpd.cita.idCita = :idCita")
    PeriodontalDisease findByCitaId(Integer idCita);
}