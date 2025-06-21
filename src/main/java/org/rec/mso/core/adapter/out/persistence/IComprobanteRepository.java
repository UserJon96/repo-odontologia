package org.rec.mso.core.adapter.out.persistence;
import org.rec.mso.core.entity.dominio.Comprobante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComprobanteRepository extends JpaRepository<Comprobante, Integer> {
}