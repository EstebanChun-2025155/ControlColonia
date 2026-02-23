package com.Administracion.Colonia.Repository;

import com.Administracion.Colonia.Entity.Casa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaRepository extends JpaRepository<Casa, Integer>{
    Boolean existsByNoDeCasaAndEstadoAndPropietarioAndPrecioCasa(
            String noDeCasa,
            String estado,
            String propietario,
            Double precioCasa
    );
}
