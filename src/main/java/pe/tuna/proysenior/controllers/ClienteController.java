package pe.tuna.proysenior.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pe.tuna.proysenior.entity.Cliente;
import pe.tuna.proysenior.entity.Region;
import pe.tuna.proysenior.service.ClienteService;
import pe.tuna.proysenior.service.UploadFileService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api")
public class ClienteController {

    private final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UploadFileService uploadFileService;

    @GetMapping("/clientes")
    private List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/clientes/page/{page}")
    private Page<Cliente> findAll(@PathVariable(name = "page") int page) {
        return clienteService.findAllPaginado(PageRequest.of(page, 4));
    }

    @GetMapping("/clientes/{id}")
    private ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        Cliente cliente = null;
        Map<String, Object> response = new HashMap<>();

        try {
            cliente = clienteService.findById(id);
        } catch (DataAccessException e) {
            response.put("isSuccess", false);
            response.put("isWarning", false);
            response.put("message", "Error al realizar la consulta por ID");
            response.put("data", null);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (cliente == null) {
            response.put("isSuccess", true);
            response.put("isWarning", true);
            response.put("data", null);
            response.put("message", "El cliente con ID: ".concat(id.toString()).concat(" no existe en la base de datos"));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("data", cliente);
        response.put("message", "Cliente encontrado");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping("/clientes")
    public ResponseEntity<?> save(@Validated @RequestBody Cliente cliente,
                                  BindingResult result) {
        Cliente clienteRegistrado = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()).collect(Collectors.toList());
            response.put("isSuccess", true);
            response.put("isWarning", true);
            response.put("message", "Ingrese campos obligatorios");
            response.put("data", null);
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            clienteRegistrado = clienteService.save(cliente);
        } catch (DataAccessException e) {
            response.put("isSuccess", false);
            response.put("isWarning", true);
            response.put("message", "Error al crear el cliente en la base de datos");
            response.put("data", null);
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("message", "Cliente creado con exito");
        response.put("data", clienteRegistrado);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //@Secured("ROLE_ADMIN")
    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> update(@Validated @RequestBody Cliente cliente,
                                    BindingResult result,
                                    @PathVariable(name = "id") Long id) {

        Cliente clienteCurrent = clienteService.findById(id);
        Cliente clienteActualizado = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(fieldError -> "el campo '" + fieldError.getField() + "' " + fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("isSuccess", false);
            response.put("isWarning", false);
            response.put("data", null);
            response.put("message", "Ingrese campos obligatorios");
            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        if (clienteCurrent == null) {
            response.put("isSuccess", false);
            response.put("isWarning", false);
            response.put("data", null);
            response.put("message", "El cliente que intenta modificar no existe en la base de datos");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            clienteCurrent.setNombre(cliente.getNombre());
            clienteCurrent.setApellido(cliente.getApellido());
            clienteCurrent.setEmail(cliente.getEmail());
            clienteCurrent.setCreateAt(cliente.getCreateAt());
            clienteCurrent.setRegion(cliente.getRegion());
            clienteActualizado = clienteService.save(clienteCurrent);
        } catch (DataAccessException e) {
            response.put("isSuccess", false);
            response.put("isWarning", false);
            response.put("data", null);
            response.put("message", "Error en BD al actualizar el cliente");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("data", clienteActualizado);
        response.put("message", "Cliente actualizado con éxito");

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    //@Secured("ROLE_ADMIN")
    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            response.put("isSuccess", false);
            response.put("isWarning", true);
            response.put("data", null);
            response.put("message", "El cliente que desea eliminar no existe");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {
            String nombreFotoOld = cliente.getFoto();
            uploadFileService.eliminar(nombreFotoOld);
            clienteService.delete(id);
        } catch (DataAccessException e) {
            response.put("isSuccess", false);
            response.put("isWarning", true);
            response.put("message", "Error al eliminar el cliente");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("isSuccess", true);
        response.put("isWarning", false);
        response.put("data", null);
        response.put("message", "Cliente eliminado con éxito");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //@Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping("/clientes/upload")
    public ResponseEntity<?> upload(@RequestParam(name = "archivo") MultipartFile archivo, @RequestParam(name = "id") Long id) {
        Map<String, Object> response = new HashMap<>();
        Cliente cliente = clienteService.findById(id);

        if (!archivo.isEmpty()) {
            String nombreArchivo = null;
            try {
                nombreArchivo = uploadFileService.copiar(archivo);
            } catch (IOException e) {
                e.printStackTrace();
                response.put("message", "Error al subir la imagen al servidor " + nombreArchivo);
                response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            String nombreFotoOld = cliente.getFoto();
            uploadFileService.eliminar(nombreFotoOld);

            cliente.setFoto(nombreArchivo);
            clienteService.save(cliente);

            response.put("isSuccess", true);
            response.put("isWarning", false);
            response.put("data", cliente);
            response.put("message", "Imagen subida correctamente");
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable(name = "nombreFoto") String nombreFoto) {
        Resource recurso = null;

        try {
            recurso = uploadFileService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("/regiones")
    public List<Region> listarRegiones(){
        return clienteService.findAllRegiones();
    }
}
