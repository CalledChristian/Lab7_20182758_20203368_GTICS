package com.example.lab7_gtics.Controller;

import com.example.lab7_gtics.Entity.Usuario;
import com.example.lab7_gtics.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")

public class UsuarioController {

    final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    //Listar Usuarios
    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {

        return usuarioRepository.findAll();
    }


    //Crear Usuario
    @PostMapping(value = "/crear")
    public ResponseEntity<HashMap<String, Object>> crearUsuario(@RequestBody Usuario usuario) {

        HashMap<String, Object> responseMap = new HashMap<>();


        if(usuario.getId() != null && usuario.getId() > 0) {
            Optional<Usuario> optUsuario = usuarioRepository.findById(usuario.getId());
            if(optUsuario.isPresent()){
                responseMap.put("error","el id ingresado ya existe");
            }else{
                usuarioRepository.save(usuario);
                responseMap.put("id creado", usuario.getId());
                //HTTP 201 CREATED
                return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
            }
        }else{
            responseMap.put("error","Debe ingresar un id para el usuario");
        }
        //HTTP 400 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> gestionExcepcion(
            HttpServletRequest request) {


        HashMap<String, Object> responseMap = new HashMap<>();

        if (request.getMethod().equals("POST")) {
            responseMap.put("error", "JSON VACIO");
        }
        //HTTP 404 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
    }
}
