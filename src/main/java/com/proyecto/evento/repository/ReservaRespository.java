package com.proyecto.evento.repository;

import com.proyecto.evento.entity.Reserva;
import com.proyecto.evento.entity.ReservaDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRespository extends JpaRepository<Reserva, Integer> {

  @Query("SELECT new com.proyecto.evento.entity.ReservaDTO(r.idReserva, r.usuario.nombre, r.usuario.correo, r.usuario.telefono, r.evento.nombre, r.fecha) FROM Reserva r")
  List<ReservaDTO> getReservas();

}
