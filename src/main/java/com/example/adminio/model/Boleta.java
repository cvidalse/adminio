package com.example.adminio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boleta_id")
    private Long id;

    @Column(name = "boleta_mes")
    private String mes;

    @Column(name = "boleta_valor")
    private double valor;

    @ManyToOne
    @JoinColumn(name = "pro_id")
    @JsonIgnore
    private Propietario propietario;

    @Column(name = "boleta_fechavencimento")
    private Date fechaVencimiento;

    @Column(name = "boleta_pago")
    private boolean pagada;

    @Column(name = "boleta_fechaemision")
    private Date fechaEmision;

    @OneToMany
    private List<GastoComun> gastoComunes;

    public Boleta(){}
    public Boleta(String mes, double valor, Propietario propietario, Date fechaVencimiento, boolean pagada, Date fechaEmision, List<GastoComun> gastoComunes) {
        this.mes = mes;
        this.valor = valor;
        this.propietario = propietario;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = pagada;
        this.fechaEmision = fechaEmision;
        this.gastoComunes = gastoComunes;
    }

    public List<GastoComun> getGastoComunes() {
        return gastoComunes;
    }

    public void setGastoComunes(List<GastoComun> gastoComunes) {
        this.gastoComunes = gastoComunes;
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

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "id=" + id +
                ", mes='" + mes + '\'' +
                ", valor=" + valor +
                ", propietario=" + propietario +
                ", fechaVencimiento=" + fechaVencimiento +
                ", pagada=" + pagada +
                ", fechaEmision=" + fechaEmision +
                ", gastoComunes=" + gastoComunes +
                '}';
    }
}
