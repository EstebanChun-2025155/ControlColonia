package com.Administracion.Colonia.Repository;

import com.Administracion.Colonia.Entity.Residente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidenteRepository extends JpaRepository<Residente, Integer> {
    boolean ExistsByNombreResidenteAndDpiResidenteAndTelefonoResidenteAndPosicionAndIdCasa(
        String nombre_residente,
        String dpi_residente,
        String telefono_residente,
        String posicion,
        Integer id_Casa
    );
}
