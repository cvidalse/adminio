package com.example.adminio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="gasto_comun")
public class GastoComun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gasto_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.DATE)
    private Date fechaPago;

    @NotNull
    @Column(name = "gasto_descrip")
    private String descripcion;

    @NotNull
    @Column(name = "gasto_valor")
    private int valor;

    @Column(name = "gasto_comprobante",nullable = true)
    private byte[] comprobante;

    @ManyToOne
    @JsonIgnore
    private Boleta boleta;

    @Override
    public String toString() {
        return "GastoComun{" +
                "fechaPago='" + fechaPago + '\'' +
                ", Descripcion='" + descripcion + '\'' +
                ", valor=" + valor +
                '}';
    }

    public GastoComun(Date fechaPago, @NotNull String descripcion, @NotNull int valor, byte[] comprobante, Boleta boleta) {
        this.fechaPago = fechaPago;
        this.descripcion = descripcion;
        this.valor = valor;
        this.comprobante = comprobante;
        this.boleta = boleta;
    }

    public GastoComun(Date fechaIngreso, String descripcion, int valor) {
        this.fechaPago = fechaIngreso;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public GastoComun(){}

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaIngreso) {
        this.fechaPago = fechaIngreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public byte[] getComprobante() {
        return comprobante;
    }

    public void setComprobante(byte[] comprobante) {
        this.comprobante = comprobante;
    }
}
