package com.proyecto.evento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.proyecto.evento.service.EventoServiceImpl;

@Controller
public class PrincipalController {

    @Autowired
    private EventoServiceImpl eventoServiceImpl;

    @GetMapping("/inicio")
    public String inicio(){
        return "index";
    }

    @GetMapping("/loginForm")
    public String formLogin(){
        return "login";
    }

    @GetMapping("/servicios")
    public String listarEventos(Model model){
        model.addAttribute("eventos", eventoServiceImpl.listar());
        return "servicio";
    }

    @GetMapping("/nosotros")
    public String nosotrosPage(){
        return "nosotros";
    }
    
}
