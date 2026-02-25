package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "limpieza")
public class Limpieza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Limpieza")
    private Integer idLimpieza;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Column(name = "puesto")
    private String puesto;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Pattern( regexp  = "^(manana|tarde)$",
            message =  "El estado es valido unicamente bajo la jornada: manana o tarde")
    @Column(name = "jornada")
    private String jornada;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @DecimalMin(value = "3100.00", message = "El precio debe ser mayor a 3100.00")
    @Column(name = "salario")
    private Double salario;

    @NotBlank(message = "El campo de texto no debe de estar vacios")
    @Size(max = 9, message = "El numero de telefono debe de iniciar con 4 numeros seguido de un - y termina con otros 4 numeros" )
    @Column(name = "telefono")
    private String telefono;

    public Integer getIdLimpieza() {
        return idLimpieza;
    }

    public void setIdLimpieza(Integer idLimplieza) {
        this.idLimpieza = idLimplieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
