package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Visita")
public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_visita")
    private Integer id_visita;

    @Column(name = "nombre_visita")
    private String nombre_visita;

    @Column(name = "documento")
    private String documento;

    @Column(name = "placa")
    private String placa;

    @Column(name = "motivo")
    private String motivo;

    @Column(name = "id_casa")
    private Integer id_casa;

    //Se agregan Getters and Setters


    public Integer getId_visita() {
        return id_visita;
    }

    public void setId_visita(Integer id_visita) {
        this.id_visita = id_visita;
    }

    public String getNombre_visita() {
        return nombre_visita;
    }

    public void setNombre_visita(String nombre_visita) {
        this.nombre_visita = nombre_visita;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Integer getId_casa() {
        return id_casa;
    }

    public void setId_casa(Integer id_casa) {
        this.id_casa = id_casa;
    }
}
