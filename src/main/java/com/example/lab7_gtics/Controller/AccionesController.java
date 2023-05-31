package com.example.lab7_gtics.Controller;

import com.example.lab7_gtics.Entity.Accion;
import com.example.lab7_gtics.Repository.AccionesRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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
        accionesRepository.save(accion);
        responseMap.put("idCreado",accion.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
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
