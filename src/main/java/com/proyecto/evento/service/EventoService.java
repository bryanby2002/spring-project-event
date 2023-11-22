package com.proyecto.evento.service;


import java.util.List;

import com.proyecto.evento.entity.Evento;

public interface EventoService {
  
  Evento guardar(Evento evento);
  List<Evento> listar();
  void eliminar(Integer id);
  Evento getById(Integer id);
  Evento actualizar(Evento evento);
}
