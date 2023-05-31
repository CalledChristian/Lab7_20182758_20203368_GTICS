package com.example.lab7_gtics.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
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
    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuario usuarios_id;

}
