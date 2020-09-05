package pe.tuna.proysenior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.tuna.proysenior.entity.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %?1%")
    public List<Producto> findByNombre(String termino);

    public List<Producto> findByNombreContainingIgnoreCase(String termino);
}
