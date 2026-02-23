package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Casa")
public class Casa {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    @Column (name = "id_casa")
    private Integer idCasa;

    @Column (name = "no_de_casa")
    private String noDeCasa;

    @Column (name = "estado")
    private String estado;

    @Column (name = "propietario")
    private String propietario;

    @Column (name = "precio_casa")
    private double precioCasa;

    public Integer getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Integer idCasa) {
        this.idCasa = idCasa;
    }

    public String getNoDeCasa() {
        return noDeCasa;
    }

    public void setNoDeCasa(String noDeCasa) {
        this.noDeCasa = noDeCasa;
    }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public double getPrecioCasa() {
        return precioCasa;
    }

    public void setPrecioCasa(double precioCasa) {
        this.precioCasa = precioCasa;
    }
}

