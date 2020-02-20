package com.example.adminio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
@Entity
@Table(name= "propiedad")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propiedad_id")
    private Long idPropiedad;

    @Column(name = "propiedad_numero")
    private int numeroPropiedad;

    @Column(name = "propiedad_metros_cuadrados")
    private int m2;

    @ManyToOne
    @JsonIgnore
    private Propietario propietario;

    public Propiedad(){};

    public Propiedad(int numeroPropiedad, int m2) {
        this.numeroPropiedad = numeroPropiedad;
        this.m2 = m2;
    }

    public Propiedad(int numeroPropiedad, int m2, Propietario propietario) {
        this.numeroPropiedad = numeroPropiedad;
        this.m2 = m2;
        this.propietario = propietario;
    }

    public Long getIdPropiedad() {
        return idPropiedad;
    }

    public void setIdPropiedad(Long idPropiedad) {
        this.idPropiedad = idPropiedad;
    }

    public int getNumeroPropiedad() {
        return numeroPropiedad;
    }

    public void setNumeroPropiedad(int numeroPropiedad) {
        this.numeroPropiedad = numeroPropiedad;
    }

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public void setPropietario(Propietario propietario){
        this.propietario= propietario;
    }
}
