package pe.tuna.proysenior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.tuna.proysenior.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

}
