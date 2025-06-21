package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ICitaRepository extends JpaRepository<Cita, Integer> {
    //List<Cita> findByIdDoctor(Integer idDoctor);
    List<Cita> findByDoctorIdDoctor(Integer idDoctor);


}