package pe.tuna.proysenior.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pe.tuna.proysenior.entity.Cliente;
import pe.tuna.proysenior.entity.Factura;
import pe.tuna.proysenior.entity.Region;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAll();

    public Page<Cliente> findAllPaginado(Pageable pageable);

    public Cliente findById(Long id);

    public Cliente save(Cliente cliente);

    public void delete(Long id);

    public List<Region> findAllRegiones();

    public Factura findFacturaById(Long id);

    public Factura saveFactura(Factura factura);

    public void deleteFacturaById(Long id);
}
