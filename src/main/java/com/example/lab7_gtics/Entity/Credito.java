package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "creditos", schema = "mydb", catalog = "")
public class Credito {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "monto")
    private String monto;
    @Basic
    @Column(name = "usuarios_id")
    private int usuariosId;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "interes")
    private Double interes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Double getInteres() {
        return interes;
    }

    public void setInteres(Double interes) {
        this.interes = interes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credito that = (Credito) o;
        return id == that.id && usuariosId == that.usuariosId && Objects.equals(monto, that.monto) && Objects.equals(fecha, that.fecha) && Objects.equals(interes, that.interes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monto, usuariosId, fecha, interes);
    }
}
