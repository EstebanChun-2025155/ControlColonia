package com.Administracion.Colonia.Repository;

import com.Administracion.Colonia.Entity.Limpieza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface LimpiezaRepository extends JpaRepository<Limpieza, Integer> {
    Boolean existsByIdLimpiezaAndNombreAndPuestoAndJornadaAndSalarioAndTelefono(
            Integer idLimpieza,
            String nombre,
            String puesto,
            String jornada,
            Double salario,
            String telefono
    );
}