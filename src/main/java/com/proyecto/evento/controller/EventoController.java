package com.proyecto.evento.controller;

import com.proyecto.evento.entity.Evento;
import com.proyecto.evento.entity.Reserva;
import com.proyecto.evento.entity.Usuario;
import com.proyecto.evento.service.CargaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.proyecto.evento.service.EventoServiceImpl;
import com.proyecto.evento.service.ReservaService;
import com.proyecto.evento.service.UsuarioServiceImpl;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Controller
@RequestMapping("/api/evento")
public class EventoController {

  private final EventoServiceImpl eventoServiceImpl;
  private final CargaService cargaService;
  private final ReservaService reservaService;
  private final UsuarioServiceImpl usuarioServiceImpl;

  public EventoController
  (
    EventoServiceImpl eventoServiceImpl,
    CargaService cargaService,
    ReservaService reservaService,
    UsuarioServiceImpl usuarioServiceImpl
  )
  {

    this.eventoServiceImpl=eventoServiceImpl;
    this.cargaService=cargaService;
    this.reservaService=reservaService;
    this.usuarioServiceImpl=usuarioServiceImpl;

  }

  @GetMapping("/gestion-evento")
  public String gestionEvento(Model model){
    model.addAttribute("eventos", eventoServiceImpl.listar());
    return "gestionEvento";
  }

  @GetMapping("/reservaMensaje")
  public String reservaMensaje(){
    return "reservaMensaje";
  }

  @GetMapping("/reservaForm")
  public String reservaForm(Model model){
    model.addAttribute("eventos", eventoServiceImpl.listar());
    model.addAttribute("reserva", new Reserva());
    return "reserva";
  }

  @PostMapping("/reservar")
  public String reservar(@ModelAttribute Reserva reserva, @RequestParam("dni") String dni){
    Usuario usuario = usuarioServiceImpl.listarPorDni(dni);
    reserva.setUsuario(usuario);
    reservaService.guardar(reserva);
    return "redirect:/api/evento/reservaMensaje";
  }

  @GetMapping("/registroForm")
  public String formularioRegistroEvento(Model model){
    model.addAttribute("evento", new Evento());
    return "nuevoEvento";
  }

  @PostMapping("/registro")
  public String registrarNuevoEvento(@ModelAttribute("evento") Evento evento,
                                     @RequestParam("file") MultipartFile file,
                                     Model model){
    try {
      //fechaActual
      LocalDate date = LocalDate.now();
      Date fechaActual = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
      String fileName = file.getOriginalFilename();
      evento.setSrcImg(fileName);
      evento.setFecha(fechaActual);
      evento.setEstado(1);
      cargaService.cargarImagen(file);
      eventoServiceImpl.guardar(evento);
      model.addAttribute("mensaje", "Registrado correctamente");
      model.addAttribute("evento", new Evento());
    }catch (IOException e){
      model.addAttribute("error", "Error al cargar la imagen");
      e.printStackTrace(System.out);
    }
    return "redirect:/servicios";
  }

  @GetMapping("/eliminar/{id}")
  public String eliminarEvento(@PathVariable("id") Integer id){
    try {
      eventoServiceImpl.eliminar(id);
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
    return "redirect:/api/evento/gestion-evento";
  }
}
