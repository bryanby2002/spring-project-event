package com.proyecto.evento.entity;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "evento")
public class Evento {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idEvento;
  private String nombre;
  private String descripcion;
  private Date fecha;
  private LocalTime horaInicio;
  private LocalTime horaFin;
  private String lugar;
  private String telefono;
  private String tipo;
  private double precio;
  private String srcImg;
  private int capacidad;
  private int estado;
  @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
  private List<Reserva> reservas;
}
