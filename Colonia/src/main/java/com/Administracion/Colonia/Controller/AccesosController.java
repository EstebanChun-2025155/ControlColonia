package com.Administracion.Colonia.Controller;

import com.Administracion.Colonia.Entity.Accesos;
import com.Administracion.Colonia.Entity.Visitas;
import com.Administracion.Colonia.Service.AccesosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accesos")
public class AccesosController {
    private final AccesosService accesosService;

    public AccesosController(AccesosService accesosService) {
        this.accesosService = accesosService;
    }

    @GetMapping
    public List<Accesos> getAccesos(){
        return accesosService.getAllAccesos();
    }

    @PostMapping
    public ResponseEntity<Object> createAcceso(@Valid @RequestBody Accesos accesos){
        try {
            Accesos createAcceso = accesosService.saveAcceso(accesos);
            return new ResponseEntity<>(createAcceso, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAcceso(@Valid @RequestBody Accesos accesos, @PathVariable Integer id){
        try {
            Accesos updateAcceso = accesosService.updateAcceso(id, accesos);
            return new ResponseEntity<>(updateAcceso, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAccesosById(@PathVariable Integer id){
        try {
            Accesos searchedAccesos = accesosService.getAccesosById(id);
            return new ResponseEntity<>(searchedAccesos,HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAccesosById(@PathVariable Integer id){
        try {
            accesosService.deleteAccesos(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
