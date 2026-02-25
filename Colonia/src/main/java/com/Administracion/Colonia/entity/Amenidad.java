package com.Administracion.Colonia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "Amenidades")
public class Amenidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAmenidad")
    private Integer idAmenidad;

    @NotBlank(message = "Debe rellenar el nombre")
    @Column(name = "nombreAmenidad")
    private String nombreAmenidad;

    @NotBlank(message = "Debe rellenar el horario")
    @Column(name = "horarioUso")
    private String horarioUso;

    @Column(name = "costoUso")
    private double costoUso;

    @NotBlank(message = "Debe rellenar el estado")
    @Column(name = "estado")
    private String estado;

    @Column(name = "capacidad")
    private Integer capacidad;

    public Integer getIdAmenidad() {
        return idAmenidad;
    }

    public void setIdAmenidad(Integer idAmenidad) {
        this.idAmenidad = idAmenidad;
    }

    public @NotBlank(message = "Debe rellenar el nombre") String getNombreAmenidad() {
        return nombreAmenidad;
    }

    public void setNombreAmenidad(@NotBlank(message = "Debe rellenar el nombre") String nombreAmenidad) {
        this.nombreAmenidad = nombreAmenidad;
    }

    public @NotBlank(message = "Debe rellenar el horario") String getHorarioUso() {
        return horarioUso;
    }

    public void setHorarioUso(@NotBlank(message = "Debe rellenar el horario") String horarioUso) {
        this.horarioUso = horarioUso;
    }

    public double getCostoUso() {
        return costoUso;
    }

    public void setCostoUso(double costoUso) {
        this.costoUso = costoUso;
    }

    public @NotBlank(message = "Debe rellenar el estado") String getEstado() {
        return estado;
    }

    public void setEstado(@NotBlank(message = "Debe rellenar el estado") String estado) {
        this.estado = estado;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }
}
