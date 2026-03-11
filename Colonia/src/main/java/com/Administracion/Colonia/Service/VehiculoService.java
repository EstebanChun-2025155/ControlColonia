package com.Administracion.Colonia.Service;

import com.Administracion.Colonia.Entity.Vehiculo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehiculoService {

    List<Vehiculo> getAllVehiculo();

    Vehiculo getVehiculoByid(Integer id);

    Vehiculo saveVehiculo(Vehiculo vehiculo);

    Vehiculo updateVehiculo(Integer id, Vehiculo vehiculo);

    void deleteVehiculo(Integer id);
}
