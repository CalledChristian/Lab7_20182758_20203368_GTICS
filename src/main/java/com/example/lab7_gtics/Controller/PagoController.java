package com.example.lab7_gtics.Controller;

import com.example.lab7_gtics.Entity.Pago;
import com.example.lab7_gtics.Entity.Usuario;
import com.example.lab7_gtics.Repository.PagoRepository;
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
@RequestMapping("/pagos")

public class PagoController {

    final UsuarioRepository usuarioRepository;
    final PagoRepository pagoRepository;

    public PagoController(UsuarioRepository usuarioRepository,PagoRepository pagoRepository) {

        this.usuarioRepository = usuarioRepository;
        this.pagoRepository = pagoRepository;
    }

    //Listar Pagos
    @GetMapping("/listarPagos")
    public List<Pago> listarPagos() {

        return pagoRepository.findAll();
    }


    //Registrar Pago
    @PostMapping(value = "/registrarPago")
    public ResponseEntity<HashMap<String, Object>> registrarPago(@RequestBody Pago pago) {

        HashMap<String, Object> responseMap = new HashMap<>();

        if(pago.getId() != null && pago.getId() > 0) {
            Optional<Pago> optPago = pagoRepository.findById(pago.getId());
            if(optPago.isPresent()){
                responseMap.put("error","el id ingresado para el pago ya existe");
            }else{
                pagoRepository.save(pago);
                responseMap.put("id ", pago.getId());
                //HTTP 201 CREATED
                return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
            }
        }else{
            responseMap.put("error","Debe ingresar un id para el pago");
        }
        //HTTP 400 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> gestionExcepcion(
            HttpServletRequest request) {


        HashMap<String, Object> responseMap = new HashMap<>();

        if (request.getMethod().equals("POST")) {
            responseMap.put("error", "Debe Ingresar Parametros");
        }
        //HTTP 404 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
    }
}