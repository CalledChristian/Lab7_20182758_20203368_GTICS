package com.example.lab7_gtics.Controller;

import com.example.lab7_gtics.Entity.Accion;
import com.example.lab7_gtics.Repository.AccionesRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(value = "acciones")
public class AccionesController {

    final AccionesRepository accionesRepository;

    public AccionesController(AccionesRepository accionesRepository) {
        this.accionesRepository = accionesRepository;
    }

    @PostMapping(value = "save")
    public ResponseEntity<HashMap<String,Object>> saveAccion(@RequestBody Accion accion){
        HashMap<String, Object> responseMap = new HashMap<>();
        if(accion.getId() != null && accion.getId() > 0) {
            Optional<Accion> optUsuario = accionesRepository.findById(accion.getId());
            if(optUsuario.isPresent()){
                responseMap.put("error","el id ingresado ya existe");
            }else{
                accionesRepository.save(accion);
                responseMap.put("id creado", accion.getId());
                //HTTP 201 CREATED
                return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
            }
        }else{
            responseMap.put("error","Debe ingresar un id para la accion");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> gestionExcepcion(
            HttpServletRequest request) {
        HashMap<String, Object> responseMap = new HashMap<>();
        if (request.getMethod().equals("POST")) {
            responseMap.put("error", "JSON VACIO");
        }
        return ResponseEntity.badRequest().body(responseMap);
    }
}
