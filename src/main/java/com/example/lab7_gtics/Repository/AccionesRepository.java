package com.example.lab7_gtics.Repository;

import com.example.lab7_gtics.Entity.Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionesRepository extends JpaRepository<Accion,Integer> {
}
