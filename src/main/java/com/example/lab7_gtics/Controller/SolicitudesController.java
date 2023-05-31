package com.example.lab7_gtics.Controller;

import com.example.lab7_gtics.Entity.Pago;
import com.example.lab7_gtics.Entity.Solicitud;
import com.example.lab7_gtics.Repository.SolicitudesRespository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudesController {

    final SolicitudesRespository solicitudesRespository;

    public SolicitudesController(SolicitudesRespository solicitudesRespository) {
        this.solicitudesRespository = solicitudesRespository;
    }

    @PostMapping(value = "/registro")
    public ResponseEntity<HashMap<String, Object>> registroSolicitud(@RequestBody Solicitud solicitud) {
        HashMap<String, Object> responseMap = new HashMap<>();
        solicitud.setId(solicitud.getId());
        responseMap.put("id: ", solicitud.getId());
        responseMap.put("Monto Solicitado: ", solicitud.getSolicitud_monto());
        solicitud.setSolicitud_estado("pendiente");
        solicitudesRespository.save(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @PutMapping(value = "aprobarSolicitud")
    public ResponseEntity<HashMap<String, Object>> aprobarSolicitud(@RequestParam("idSolicitud") String idSolicitud){
        HashMap<String, Object> responseMap = new HashMap<>();
        try {
            Integer id = Integer.parseInt(idSolicitud);
            Optional<Solicitud> solicitudOptional = solicitudesRespository.findById(id);
            if(solicitudOptional.isPresent()){
                Solicitud solicitud = solicitudOptional.get();
                if(solicitud.getSolicitud_estado().equalsIgnoreCase("pendiente")){
                    solicitud.setSolicitud_estado("aprobado");
                    solicitudesRespository.save(solicitud);
                    responseMap.put("id solicitud",id);
                    return ResponseEntity.status(HttpStatus.OK).body(responseMap);
                }
                else {
                    responseMap.put("Solicitud ya atendida",id);
                    return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(responseMap);
                }
            }else {
                responseMap.put("error","No se encontro el id");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
            }
        }catch (NumberFormatException e){
            responseMap.put("error","Debe ingresar un nuemero");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        }
    }

    @PutMapping(value = "denegarSolicitud")
    public ResponseEntity<HashMap<String, Object>> dengarSolicitud(@RequestParam("idSolicitud") String idSolicitud){
        HashMap<String, Object> responseMap = new HashMap<>();
        try {
            Integer id = Integer.parseInt(idSolicitud);
            Optional<Solicitud> solicitudOptional = solicitudesRespository.findById(id);
            if(solicitudOptional.isPresent()){
                Solicitud solicitud = solicitudOptional.get();
                if(solicitud.getSolicitud_estado().equalsIgnoreCase("pendiente")){
                    solicitud.setSolicitud_estado("denegado");
                    solicitudesRespository.save(solicitud);
                    responseMap.put("id solicitud",id);
                    return ResponseEntity.status(HttpStatus.OK).body(responseMap);
                }
                else {
                    responseMap.put("Solicitud ya atendida",id);
                    return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(responseMap);
                }
            }else {
                responseMap.put("error","No se encontro el id");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
            }
        }catch (NumberFormatException e){
            responseMap.put("error","Debe ingresar un nuemero");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        }
    }


    @DeleteMapping(value = "borrarSolicitud")
    public ResponseEntity<HashMap<String, Object>> borrarSolicitud(@RequestParam("idSolicitud") String idSolicitud){
        HashMap<String, Object> responseMap = new HashMap<>();
        try {
            Integer id = Integer.parseInt(idSolicitud);
            Optional<Solicitud> solicitudOptional = solicitudesRespository.findById(id);
            if(solicitudOptional.isPresent()){
                Solicitud solicitud = solicitudOptional.get();
                if(solicitud.getSolicitud_estado().equalsIgnoreCase("denegado")){
                    solicitudesRespository.deleteById(id);
                    responseMap.put("id solicitud borrada",id);
                    return ResponseEntity.status(HttpStatus.OK).body(responseMap);
                }
                else {
                    responseMap.put("error","Solo se puede eliminar una solicitud que ha sido denegada");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
                }
            }else {
                responseMap.put("error","No se encontro el id");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseMap);
            }
        }catch (NumberFormatException e){
            responseMap.put("error","Debe ingresar un nuemero");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseMap);
        }
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String, Object>> gestionExcepcion(
            HttpServletRequest request) {
        HashMap<String, Object> responseMap = new HashMap<>();

        if (request.getMethod().equals("POST")||request.getMethod().equals("PUT")||request.getMethod().equals("DELETE")) {
            responseMap.put("error", "Debe Ingresar Parametros");
        }
        //HTTP 404 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<HashMap<String, Object>> gestion(
            HttpServletRequest request) {
        HashMap<String, Object> responseMap = new HashMap<>();

        if (request.getMethod().equals("PUT")||request.getMethod().equals("DELETE")) {
            responseMap.put("error", "Debe Ingresar Parametros");
        }
        //HTTP 404 BAD REQUEST
        return ResponseEntity.badRequest().body(responseMap);
    }
}
