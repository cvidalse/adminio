package com.example.adminio.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    @Column(name = "gasto_fecha")
    private String fechaIngreso;

    @NotNull
    @Column(name = "gasto_descrip")
    private String descripcion;

    @NotNull
    @Column(name = "gasto_valor")
    private int valor;

    @Column(name = "gasto_comprobante",nullable = true)
    private byte[] comprobante;

    @Override
    public String toString() {
        return "GastoComun{" +
                "fechaIngreso='" + fechaIngreso + '\'' +
                ", Descripcion='" + descripcion + '\'' +
                ", valor=" + valor +
                '}';
    }

    public GastoComun(String fechaIngreso, String descripcion, int valor) {
        this.fechaIngreso = fechaIngreso;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public GastoComun(){}

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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
