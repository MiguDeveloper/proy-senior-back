package pe.tuna.proysenior.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.tuna.proysenior.entity.Cliente;
import pe.tuna.proysenior.entity.Factura;
import pe.tuna.proysenior.entity.Region;
import pe.tuna.proysenior.repository.ClienteRepository;
import pe.tuna.proysenior.repository.FacturaRepository;
import pe.tuna.proysenior.service.ClienteService;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAllPaginado(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return clienteRepository.findAllRegiones();
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Factura saveFactura(Factura factura) {
        return facturaRepository.save(factura);
    }

    @Override
    @Transactional
    public void deleteFacturaById(Long id) {
        facturaRepository.deleteById(id);
    }
}
