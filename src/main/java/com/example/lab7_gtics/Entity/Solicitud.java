package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "solicitudes", schema = "mydb", catalog = "")
public class Solicitud {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "solicitud_producto")
    private String solicitud_producto;
    @Basic
    @Column(name = "solicitud_monto")
    private Double solicitud_monto;
    @Basic
    @Column(name = "solicitud_fecha")
    private Timestamp solicitud_fecha;
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuarios_id;
    @Basic
    @Column(name = "solicitud_estado")
    private String solicitud_estado;

}
