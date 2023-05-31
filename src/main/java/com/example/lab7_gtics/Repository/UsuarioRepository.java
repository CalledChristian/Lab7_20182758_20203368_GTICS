package com.example.lab7_gtics.Repository;

import com.example.lab7_gtics.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
