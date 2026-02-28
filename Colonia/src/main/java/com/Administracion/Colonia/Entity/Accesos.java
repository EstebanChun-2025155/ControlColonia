package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "Accesos")
public class Accesos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_acceso")
    private Integer id;

    @NotBlank(message = "El campo de texto no debe de estar vacio")
    @Column(name = "tipo_persona")
    private String tipoPersona;

    @NotNull(message = "El campo no puede estar vacio")
    @Column(name = "id_seguridad")
    private Integer idSeguridad;

    @NotNull(message = "La hora de entrada no puede estar vacía")
    @Column(name = "hora_entrada")
    private LocalDateTime horaEntrada;

    @NotNull(message = "La hora de entrada no puede estar vacía")
    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public Integer getIdSeguridad() {
        return idSeguridad;
    }

    public void setIdSeguridad(Integer idSeguridad) {
        this.idSeguridad = idSeguridad;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }
}
