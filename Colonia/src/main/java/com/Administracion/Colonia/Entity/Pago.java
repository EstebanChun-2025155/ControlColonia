package com.Administracion.Colonia.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Pago")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_Pago")
    private Integer idPago;

    @Column (name = "id_Residente")
    private Integer idResidente;

    @NotBlank(message = "El campo de texto no debe de estar vacio")
    @Pattern( regexp = "^(multa|mantenimiento|amenidad)$",
            message = "La clasificación del pago es valido unicamente bajo los dominios: multa, mantenimiento, amenidad")
    @Column (name = "clasificacion_Pago")
    private String clasificacionPago;

    @DecimalMin(value = "75.01", message = "El monto debe ser mayor a 75.00")
    @Column (name = "monto")
    private Double monto;

    @NotBlank(message = "El campo de texto no debe de estar vacio")
    @Size(max = 10, message = "La fecha de pago no puede exceder 10 caracteres")
    @Column (name = "fecha_Pago")
    private String fechaPago;

    @NotBlank(message = "El campo de texto no debe de estar vacio")
    @Pattern( regexp = "^(efectivo|transferencia|tarjeta)$",
            message = "El método de pago es valido unicamente bajo los dominios: efectivo, transferencia, tarjeta")
    @Column (name = "metodo")
    private String metodo;

    @NotBlank(message = "El campo de texto no debe de estar vacio")
    @Size(max = 6, message = "La referencia no puede exceder 6 caracteres")
    @Column (name = "referencia")
    private String referencia;
}