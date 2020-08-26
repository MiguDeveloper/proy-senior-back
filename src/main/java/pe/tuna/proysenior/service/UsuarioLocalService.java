package pe.tuna.proysenior.service;

import pe.tuna.proysenior.entity.Usuario;

public interface UsuarioLocalService {
    public Usuario findByUsername(String username);
}
