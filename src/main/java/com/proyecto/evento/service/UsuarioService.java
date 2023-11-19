package com.proyecto.evento.service;

import java.util.List;

import com.proyecto.evento.entity.Usuario;

public interface UsuarioService {

    Usuario guardar(Usuario usuario);
    Usuario validar(String correo, String contrasena);
    List<Usuario> listar();
    Usuario listarPorDni(String dni);

}
