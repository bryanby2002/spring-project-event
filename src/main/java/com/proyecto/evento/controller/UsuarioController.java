package com.proyecto.evento.controller;

import com.proyecto.evento.entity.Usuario;
import com.proyecto.evento.service.UsuarioServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/direccionador")
    public String direccionador(){
        return "direccionador";
    }
    @GetMapping("/registro")
    public String formNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "nuevoUsuario";
    }

    @PostMapping("/guardar")
    public String guardarNuevoUsuario(@ModelAttribute("usuario") Usuario usuario,
            Model model) {
        usuario.setRol("Participante");
        usuarioService.guardar(usuario);
        model.addAttribute("mensaje", "Registrado correctamente");
        model.addAttribute("usuario", new Usuario());
        return "redirect:/loginForm";
    }

    @PostMapping("/validar")
    public String validarUsuario(@RequestParam("correo") String correo,
                                 @RequestParam("contrasena") String contrasena,
                                 Model model){
        final String ROL_ADMINISTRADOR = "Administrador";
        final String ROL_PARTICIPANTE = "Participante";
        Usuario usuario = usuarioService.validar(correo, contrasena);
        if(usuario!=null){
            if(ROL_ADMINISTRADOR.equals(usuario.getRol())){
                model.addAttribute("mensaje", "Bienvenido "+usuario.getNombre());
                return "redirect:/api/usuario/direccionador";
            } else if (ROL_PARTICIPANTE.equals(usuario.getRol())){
                model.addAttribute("mensaje", "Bienvenido "+usuario.getNombre());
                return "redirect:/inicio";
            }
        }
        model.addAttribute("error","Correo o contraseña invalida");
        return "login";
    }
}
