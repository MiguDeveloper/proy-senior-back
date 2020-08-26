package pe.tuna.proysenior.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.tuna.proysenior.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByUsername(String username);

    @Query("select u from Usuario u where  u.username = ?1")
    public Usuario findByUsername2(String username);
}
