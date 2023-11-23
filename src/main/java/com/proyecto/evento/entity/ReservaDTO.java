package com.proyecto.evento.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservaDTO {

  private Integer idReserva;
  private String nombreUsuario;
  private String correoUsuario;
  private String telefonoUsuario;
  private String nombreEvento;
  private Date fechaReserva;

}
