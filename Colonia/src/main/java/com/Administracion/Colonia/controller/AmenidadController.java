package com.Administracion.Colonia.controller;

import com.Administracion.Colonia.entity.Amenidad;
import com.Administracion.Colonia.repository.AmenidadRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/amenidades")
public class AmenidadController {

    private final AmenidadRepository amenidadRepository;

    public AmenidadController(AmenidadRepository amenidadRepository){
        this.amenidadRepository = amenidadRepository;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Amenidad> listarTodos(){
        return amenidadRepository.findAll();
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Object> crearAmenidad(@Valid @RequestBody Amenidad amenidad, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errores.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        Amenidad nuevo = amenidadRepository.save(amenidad);
        return ResponseEntity.ok(nuevo);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarAmenidad(@PathVariable Integer id, @Valid @RequestBody Amenidad amenidadActualizado, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }

        return amenidadRepository.findById(id).map(amenidad -> {

            amenidad.setNombreAmenidad(amenidadActualizado.getNombreAmenidad());
            amenidad.setHorarioUso(amenidadActualizado.getHorarioUso());
            amenidad.setCostoUso(amenidadActualizado.getCostoUso());
            amenidad.setEstado(amenidadActualizado.getEstado());
            amenidad.setCapacidad(amenidadActualizado.getCapacidad());

            return ResponseEntity.ok(amenidadRepository.save(amenidad));

        }).orElse(ResponseEntity.notFound().build());
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAmenidad(@PathVariable Integer id){
        if(!amenidadRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        amenidadRepository.deleteById(id);
        return ResponseEntity.ok("Amenidad eliminado correctamente");
    }
}

