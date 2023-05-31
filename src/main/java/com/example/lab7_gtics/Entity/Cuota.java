package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cuotas", schema = "mydb", catalog = "")
public class Cuota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "numero_cuota")
    private Integer numeroCuota;
    @Basic
    @Column(name = "monto")
    private Double monto;
    @Basic
    @Column(name = "creditos_id")
    private int creditosId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getNumeroCuota() {
        return numeroCuota;
    }

    public void setNumeroCuota(Integer numeroCuota) {
        this.numeroCuota = numeroCuota;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
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
        Cuota that = (Cuota) o;
        return id == that.id && creditosId == that.creditosId && Objects.equals(numeroCuota, that.numeroCuota) && Objects.equals(monto, that.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroCuota, monto, creditosId);
    }
}
