package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "rol")
public class Rol {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nombre_rol")
    private String nombre_rol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

}
