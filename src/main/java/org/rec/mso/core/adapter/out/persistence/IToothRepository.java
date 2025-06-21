package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.Tooth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IToothRepository extends JpaRepository<Tooth, Integer> {
    @Query("SELECT t FROM Tooth t JOIN CitaTooth ct ON t.id = ct.tooth.id WHERE ct.cita.idCita = :idCita")
    List<Tooth> findByCitaId(Integer idCita);
}