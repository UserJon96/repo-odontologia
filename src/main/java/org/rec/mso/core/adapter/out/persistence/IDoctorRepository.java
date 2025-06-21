package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
    //Optional<Doctor> findByIdpersona(Integer idpersona);
    Optional<Doctor> findByPersonaId(Integer idpersona);

}



