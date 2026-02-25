package com.Administracion.Colonia.Controller;

import com.Administracion.Colonia.Entity.Residente;
import com.Administracion.Colonia.Service.ResidenteServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/residente")
public class ResidenteController {
    private final ResidenteServices residenteServices;

    public ResidenteController(ResidenteServices residenteServices) {
        this.residenteServices = residenteServices;
    }

    @GetMapping
    public List<Residente> getAllResidente(){ return residenteServices.getAllResidente(); }

    @PostMapping
    public ResponseEntity<Object> createResidente(@Valid @RequestBody Residente residente, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }

        try {
            Residente createResidente = residenteServices.saveResidente(residente);
            return new ResponseEntity<>(createResidente, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteResidente(@PathVariable Integer id){
        try {
            if (residenteServices.getResidenteById(id) == null) {
                return ResponseEntity.status(404).body("No existe esta Casa");
            }
            residenteServices.deleteResidente(id);
            return ResponseEntity.status(202).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar Residente");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateResidente(@PathVariable Integer id, @Valid @RequestBody Residente residente, BindingResult br){
        if (br.hasErrors()){
            return ResponseEntity.badRequest().body(br.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            Residente actualizado = residenteServices.updateResidente(id, residente);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
