package com.proyecto.evento.repository;

import com.proyecto.evento.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

        @Query("SELECT u FROM Usuario u WHERE u.dni=:dni")
        Usuario usuarioPorDni(@Param(value = "dni") String dni);

        @Query("SELECT u FROM Usuario u " +
                        "WHERE u.correo = :correo " +
                        "AND u.contrasena = :contrasena " +
                        "AND (u.rol = 'Administrador' OR u.rol = 'Participante')")
        Usuario validarUsuario(@Param(value = "correo") String correo,
                        @Param(value = "contrasena") String contrasena);
        

}
