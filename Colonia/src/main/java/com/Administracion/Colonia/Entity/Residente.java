package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Residente")
public class Residente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_Residente")
    private Integer id_residente;

    @NotBlank(message = "Los campos no pueden estar vacios")
    @Column(name = "nombre_Residente")
    private String nomrbe_residente;

    @NotBlank(message = "Los campos no pueden estar vacios")
    @Size(max = 13, message = "El dpi solo puede tener 13 caracteres")
    @Column(name = "dpi_Residente")
    private String dpi_residente;

    @NotBlank(message = "Los campos no pueden estar vacios")
    @Size(max = 8, message = "El telefono no puede tener mas de 8 caracteres")
    @Size(min = 8, message = "El telegono no puede tener menos de 8 caracteres")
    @Column(name = "telefono_Residente")
    private String telefono_residente;

    @NotBlank(message = "Los campos no pueden estar vacios")
    @Pattern(regexp = "^(activo | inactivo)$",
            message = "La posicion solo es valida bajo los dominios: activo, inactivo")
    @Column(name = "posicion")
    private String posicion;

    @NotEmpty(message = "Los campos no pueden estar vacios")
    @Column(name = "id_Casa")
    private Integer id_Casa;

    public Integer getId_residente() {
        return id_residente;
    }

    public void setId_residente(Integer id_residente) {
        this.id_residente = id_residente;
    }

    public String getNomrbe_residente() {
        return nomrbe_residente;
    }

    public void setNomrbe_residente(String nomrbe_residente) {
        this.nomrbe_residente = nomrbe_residente;
    }

    public String getDpi_residente() {
        return dpi_residente;
    }

    public void setDpi_residente(String dpi_residente) {
        this.dpi_residente = dpi_residente;
    }

    public String getTelefono_residente() {
        return telefono_residente;
    }

    public void setTelefono_residente(String telefono_residente) {
        this.telefono_residente = telefono_residente;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getId_Casa() {
        return id_Casa;
    }

    public void setId_Casa(Integer id_Casa) {
        this.id_Casa = id_Casa;
    }
}
