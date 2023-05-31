package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "desembolsos", schema = "mydb", catalog = "")
public class Desembolso {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "monto_desembolso")
    private String montoDesembolso;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @Basic
    @Column(name = "creditos_id")
    private int creditosId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMontoDesembolso() {
        return montoDesembolso;
    }

    public void setMontoDesembolso(String montoDesembolso) {
        this.montoDesembolso = montoDesembolso;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getCreditosId() {
        return creditosId;
    }

    public void setCreditosId(int creditosId) {
        this.creditosId = creditosId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Desembolso that = (Desembolso) o;
        return id == that.id && creditosId == that.creditosId && Objects.equals(montoDesembolso, that.montoDesembolso) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montoDesembolso, fecha, creditosId);
    }
}
