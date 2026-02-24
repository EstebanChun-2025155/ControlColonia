package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Visita")
public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Visita")
    private Integer id_Visita;

    @Column(name = "nombre_Visita")
    private String nombre_Visita;

    @Column(name = "documento")
    private String documento;

    @Column(name = "placa")
    private String placa;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "id_Casa")
    private Integer id_Casa;

    //Se agregan Getters and Setters


    public Integer getId_visita() {
        return id_Visita;
    }

    public String getNombre_visita() {
        return nombre_Visita;
    }

    public String getDocumento() {
        return documento;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMotivo() {
        return motivo;
    }

    public Integer getId_casa() {
        return id_Casa;
    }

    public void setId_visita(Integer id_visita) {
        this.id_Visita = id_visita;
    }

    public void setNombre_visita(String nombre_visita) {
        this.nombre_Visita = nombre_visita;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setId_casa(Integer id_casa) {
        this.id_Casa = id_casa;
    }
}
