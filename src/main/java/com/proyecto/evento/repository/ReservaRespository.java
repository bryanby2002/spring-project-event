package com.proyecto.evento.repository;

import com.proyecto.evento.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRespository extends JpaRepository<Reserva, Integer> {

}
