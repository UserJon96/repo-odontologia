package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.ToothPiece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IToothPieceRepository extends JpaRepository<ToothPiece, Integer> {

    @Query("SELECT tp FROM ToothPiece tp JOIN CitaToothPiece ctp ON tp.id = ctp.toothPiece.id WHERE ctp.cita.idCita = :idCita")
    List<ToothPiece> findByCitaId(Integer idCita);
}