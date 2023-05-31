package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "acciones", schema = "mydb", catalog = "")
public class Accion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "monto")
    private Double monto;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "usuarios_id")
    private int usuariosId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accion that = (Accion) o;
        return id == that.id && usuariosId == that.usuariosId && Objects.equals(monto, that.monto) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monto, fecha, usuariosId);
    }
}
