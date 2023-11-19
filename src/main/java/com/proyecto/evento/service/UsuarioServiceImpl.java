package com.proyecto.evento.service;

import com.proyecto.evento.entity.Usuario;
import com.proyecto.evento.repository.UsuarioRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{


    private final UsuarioRepository usuarioRepository;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario validar(String correo, String contrasena) {
        return usuarioRepository.validarUsuario(correo,contrasena);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario listarPorDni(String dni) {
        return usuarioRepository.usuarioPorDni(dni);
    }

}
