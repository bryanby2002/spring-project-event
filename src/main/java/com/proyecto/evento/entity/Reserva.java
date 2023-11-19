package com.proyecto.evento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idEvento", referencedColumnName = "idEvento")
    private Evento evento;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
    private List<Reporte> reportes;

}
