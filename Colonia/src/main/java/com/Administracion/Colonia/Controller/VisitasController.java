package com.Administracion.Colonia.Controller;

import com.Administracion.Colonia.Entity.Visitas;
import com.Administracion.Colonia.Service.VisitasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitas")
public class VisitasController {
    private  final VisitasService visitasService;

    public VisitasController(VisitasService visitasService) {
        this.visitasService = visitasService;
    }

    @GetMapping
    public List<Visitas> getAllVisitas(){
        return  visitasService.getAllVisitas();
    }

    @PostMapping
    public ResponseEntity<Object> createVisita(@Valid @RequestBody Visitas visitas){
        try {
            Visitas createVisita = visitasService.saveVisitas(visitas);
            return new ResponseEntity<>(createVisita, HttpStatus.CREATED);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVisitas(@Valid @RequestBody Visitas visitas, @PathVariable Integer id){
        try {
            Visitas updateVisitas = visitasService.updateVisitas(id, visitas);
            return new ResponseEntity<>(updateVisitas, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVisitasById(@PathVariable Integer id){
        try {
            Visitas searchedVisitas = visitasService.getVisitasById(id);
            return new ResponseEntity<>(searchedVisitas,HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVisitasById(@PathVariable Integer id){
        try {
            visitasService.deleteVisitas(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}