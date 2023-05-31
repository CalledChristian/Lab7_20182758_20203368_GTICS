package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "solicitudes", schema = "mydb", catalog = "")
public class Solicitud {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "solicitud_producto")
    private String solicitudProducto;
    @Basic
    @Column(name = "solicitud_monto")
    private Double solicitudMonto;
    @Basic
    @Column(name = "solicitud_fecha")
    private Timestamp solicitudFecha;
    @Basic
    @Column(name = "usuarios_id")
    private int usuariosId;
    @Basic
    @Column(name = "solicitud_estado")
    private String solicitudEstado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolicitudProducto() {
        return solicitudProducto;
    }

    public void setSolicitudProducto(String solicitudProducto) {
        this.solicitudProducto = solicitudProducto;
    }

    public Double getSolicitudMonto() {
        return solicitudMonto;
    }

    public void setSolicitudMonto(Double solicitudMonto) {
        this.solicitudMonto = solicitudMonto;
    }

    public Timestamp getSolicitudFecha() {
        return solicitudFecha;
    }

    public void setSolicitudFecha(Timestamp solicitudFecha) {
        this.solicitudFecha = solicitudFecha;
    }

    public int getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(int usuariosId) {
        this.usuariosId = usuariosId;
    }

    public String getSolicitudEstado() {
        return solicitudEstado;
    }

    public void setSolicitudEstado(String solicitudEstado) {
        this.solicitudEstado = solicitudEstado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitud that = (Solicitud) o;
        return id == that.id && usuariosId == that.usuariosId && Objects.equals(solicitudProducto, that.solicitudProducto) && Objects.equals(solicitudMonto, that.solicitudMonto) && Objects.equals(solicitudFecha, that.solicitudFecha) && Objects.equals(solicitudEstado, that.solicitudEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, solicitudProducto, solicitudMonto, solicitudFecha, usuariosId, solicitudEstado);
    }
}
