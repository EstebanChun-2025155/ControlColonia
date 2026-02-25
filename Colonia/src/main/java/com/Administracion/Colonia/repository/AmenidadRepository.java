package com.Administracion.Colonia.repository;

import com.Administracion.Colonia.entity.Amenidad;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface AmenidadRepository extends JpaRepository<Amenidad,Integer> {
    Boolean existsByNombreAmenidadAndHorarioUsoAndCostoUsoAndEstadoAndCapacidad(
            String nombreAmenidad,
            String horarioUso,
            double costoUso,
            String estado,
            Integer capacidad
    );

    boolean existsByNombreAmenidadAndHorarioUsoAndCostoUsoAndEstadoAndCapacidad(Integer idAmenidad, @NotBlank(message = "Debe rellenar el nombre") String nombreAmenidad, @NotBlank(message = "Debe rellenar el horario") String horarioUso, double costoUso, @NotBlank(message = "Debe rellenar el estado") String estado, Integer capacidad);
}
