package pe.tuna.proysenior.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.tuna.proysenior.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();

    public Page<Cliente> findAllPaginado(Pageable pageable);

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);
}
