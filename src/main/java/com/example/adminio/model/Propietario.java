package com.example.adminio.model;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "propietario")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id")
    private Long id;

    @Column(name = "pro_nombre")
    private String nombre;

    @Column(name = "pro_correo")
    private String correo;

    @Column(name = "pro_ntelefono")
    private String ntelefono;

    @Column(name = "pro_direccion")
    private String direccion;

    @Column(name = "pro_contrasena")
    private String contrasena;

    @Column(name = "pro_m2")
    private int m2;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pro_id")
    private Set<Boleta> boletas;

    public Propietario(Long id, String nombre,int m2) {
        this.id = id;
        this.nombre= nombre;
        this.m2=m2;
    }

    public Propietario(){}

    public int getM2() {
        return m2;
    }

    public void setM2(int m2) {
        this.m2 = m2;
    }

    public Propietario(String nombre, String correo, String ntelefono, String direccion, String contraseña) {
        this.nombre = nombre;
        this.correo = correo;
        this.ntelefono = ntelefono;
        this.direccion = direccion;
        this.contrasena = contraseña;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", ntelefono='" + ntelefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contraseña='" + contrasena + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNtelefono() {
        return ntelefono;
    }

    public void setNtelefono(String ntelefono) {
        this.ntelefono = ntelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(Set<Boleta> boletas) {
        this.boletas = boletas;
    }
}
