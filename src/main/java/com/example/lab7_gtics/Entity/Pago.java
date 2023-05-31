package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "pagos")
public class Pago {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "monto")
    private Double monto;
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuarios_id;
    @Basic
    @Column(name = "tipo_pago")
    private String tipo_pago;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;
    @ManyToOne
    @JoinColumn(name = "creditos_id")
    private Credito creditos_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Usuario getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(Usuario usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Credito getCreditos_id() {
        return creditos_id;
    }

    public void setCreditos_id(Credito creditos_id) {
        this.creditos_id = creditos_id;
    }
}
