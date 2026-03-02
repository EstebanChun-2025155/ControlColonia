package com.Administracion.Colonia.Repository;

import com.Administracion.Colonia.Entity.Multa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Integer> {
    Boolean existsByMontoAndDescripcionAndFechaEmisionAndEstadoAndTipoPersona (
            Double monto,
            String descripcion,
            String fechaEmision,
            String estado,
            String tipoPersona
    );
}