package com.Administracion.Colonia.Repository;

import com.Administracion.Colonia.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo,Integer> {

    Boolean existsByIdVehiculoAndPlacaAndMarcaModeloAndColorAndPropietarioAndIdCasa(
            Integer idVehiculo,
            String placa,
            String marcaModelo,
            String color,
            String propietario,
            Integer idCasa
    );
}
