package pe.tuna.proysenior.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.tuna.proysenior.entity.Cliente;
import pe.tuna.proysenior.entity.Factura;
import pe.tuna.proysenior.entity.Producto;
import pe.tuna.proysenior.service.ClienteService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class FacturaController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/facturas/{id}")
    public ResponseEntity<?> getFactura(@PathVariable(name = "id") Long id) {
        Factura factura = null;
        Map<String, Object> response = new HashMap<>();

        try {
            factura = clienteService.findFacturaById(id);
        } catch (DataAccessException e) {
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (factura == null) {
            response.put("isSuccess", true);
            response.put("isWarning", false);
            response.put("data", null);
            response.put("message", "La factura con ID: ".concat(id.toString()).concat(" no existe"));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("data", factura);
        response.put("message", "factura encontrada con exito");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }

    @DeleteMapping("/facturas/{id}")
    public ResponseEntity<?> eleminarFactura(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Factura factura = clienteService.findFacturaById(id);

        if (factura == null) {
            response.put("message", "No se encuentra el nro de factura seleccionada");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteService.deleteFacturaById(id);
        } catch (DataAccessException e) {
            response.put("message", "Ocurrio un error al eliminar factura de base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("message", "La factura fue eliminada con éxito");
        response.put("data", null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/facturas/filtrar-productos/{termino}")
    public ResponseEntity<?> filtrarProductos(@PathVariable(name = "termino") String termino) {
        Map<String, Object> response = new HashMap<>();
        List<Producto> productos = new ArrayList<>();

        try {
            productos = clienteService.findProductoByNombre(termino);
        } catch (DataAccessException e) {
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("message", "hubo un error en la base de datos");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("message", "Busqueda realizada");
        response.put("data", productos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
