package com.example.adminio.Utiles.DataAuxiliar;

import com.example.adminio.model.Propietario;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class BoletaAuxiliar {

    private long id;

    private String mes;


    private double valor;

    private Date fechaVencimiento;

    private boolean pagada;

    private Date fechaEmision;

    public BoletaAuxiliar(long id, String mes, double valor, Date fechaVencimiento, boolean pagada, Date fechaEmision) {
        this.id = id;
        this.mes = mes;
        this.valor = valor;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = pagada;
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "BoletaAuxiliar{" +
                "id=" + id +
                ", mes='" + mes + '\'' +
                ", valor=" + valor +
                ", fechaVencimiento=" + fechaVencimiento +
                ", pagada=" + pagada +
                ", fechaEmision=" + fechaEmision +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
