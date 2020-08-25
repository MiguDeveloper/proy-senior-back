package pe.tuna.proysenior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tuna.proysenior.entity.Cliente;
import pe.tuna.proysenior.entity.Region;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("FROM Region")
    public List<Region> findAllRegiones();
}
