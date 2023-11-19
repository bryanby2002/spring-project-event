package com.proyecto.evento.service;

import com.proyecto.evento.entity.Reserva;
import com.proyecto.evento.repository.ReservaRespository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRespository reservaRespository;
    public ReservaService(ReservaRespository reservaRespository){
        this.reservaRespository=reservaRespository;
    }

    public Reserva guardar(Reserva reserva){
        return reservaRespository.save(reserva);
    }
}
