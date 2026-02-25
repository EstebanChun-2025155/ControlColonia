package com.Administracion.Colonia.controller;

import com.Administracion.Colonia.entity.Vehiculo;
import com.Administracion.Colonia.repository.VehiculoRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoController(VehiculoRepository vehiculoRepository){
        this.vehiculoRepository = vehiculoRepository;
    }

    // LISTAR TODOS
    @GetMapping
    public List<Vehiculo> listarTodos(){
        return vehiculoRepository.findAll();
    }

    // CREAR
    @PostMapping
    public ResponseEntity<Object> crearVehiculo(@Valid @RequestBody Vehiculo vehiculo, BindingResult bindingResult) {

        if (bindingResult.hasErrors()){
            Map<String, String> errores = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errores.put(error.getField(),error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }
        Vehiculo nuevo = vehiculoRepository.save(vehiculo);
        return ResponseEntity.ok(nuevo);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarVehiculo(@PathVariable Integer id, @Valid @RequestBody Vehiculo vehiculoActulizado, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String,String> errores = new HashMap<>();
            for (FieldError error : bindingResult.getFieldErrors()){
                errores.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }
        return vehiculoRepository.findById(id).map(vehiculo -> {

            vehiculo.setIdVehiculo(vehiculoActulizado.getIdVehiculo());
            vehiculo.setPlaca(vehiculoActulizado.getPlaca());
            vehiculo.setMarcaModelo(vehiculoActulizado.getMarcaModelo());
            vehiculo.setColor(vehiculoActulizado.getColor());
            vehiculo.setPropietario(vehiculoActulizado.getPropietario());


            return ResponseEntity.ok(vehiculoRepository.save(vehiculo));

        }).orElse(ResponseEntity.notFound().build());
    }

    //ELIMINAR
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminaroVehiculo(@PathVariable Integer id){
        if(!vehiculoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        vehiculoRepository.deleteById(id);
        return ResponseEntity.ok("Vehiculo eliminado correctamente");
    }

}
