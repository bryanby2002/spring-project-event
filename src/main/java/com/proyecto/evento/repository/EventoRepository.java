package com.proyecto.evento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.evento.entity.Evento;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer>{
  
}
