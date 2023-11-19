package com.proyecto.evento.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.proyecto.evento.entity.Evento;
import com.proyecto.evento.repository.EventoRepository;

@Service
public class EventoServiceImpl  implements EventoService{

  private final EventoRepository eventoRepository;
  public EventoServiceImpl(EventoRepository eventoRepository){
    this.eventoRepository=eventoRepository;
  }

  @Override
  public Evento guardar(Evento evento) {
    return eventoRepository.save(evento);
  }

  @Override
  public List<Evento> listar() {
    return eventoRepository.findAll();
  }

  @Override
  public void eliminar(Integer id) {
    this.eventoRepository.deleteById(id);
  }
  
}
