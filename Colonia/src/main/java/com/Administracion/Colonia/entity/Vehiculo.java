package com.Administracion.Colonia.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name ="Vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idVehiculo")
    private Integer idVehiculo;

    @NotBlank(message = "Debe agregar la placa")
    @Column(name = "placa")
    private String placa;

    @NotBlank(message = "Debe llenar el campo")
    @Column(name = "marcaModelo")
    private String marcaModelo;

    @NotBlank(message = "Debe llenar el campo")
    @Column(name = "color")
    private String color;

    @NotBlank(message = "Debe llenar el campo")
    @Column(name = "propietario")
    private String propietario;

    @Column(name = "idCasa")
    private Integer idCasa;

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public @NotBlank(message = "Debe agregar la placa") String getPlaca() {
        return placa;
    }

    public void setPlaca(@NotBlank(message = "Debe agregar la placa") String placa) {
        this.placa = placa;
    }

    public @NotBlank(message = "Debe llenar el campo") String getMarcaModelo() {
        return marcaModelo;
    }

    public void setMarcaModelo(@NotBlank(message = "Debe llenar el campo") String marcaModelo) {
        this.marcaModelo = marcaModelo;
    }

    public @NotBlank(message = "Debe llenar el campo") String getColor() {
        return color;
    }

    public void setColor(@NotBlank(message = "Debe llenar el campo") String color) {
        this.color = color;
    }

    public @NotBlank(message = "Debe llenar el campo") String getPropietario() {
        return propietario;
    }

    public void setPropietario(@NotBlank(message = "Debe llenar el campo") String propietario) {
        this.propietario = propietario;
    }

    public Integer getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }
}