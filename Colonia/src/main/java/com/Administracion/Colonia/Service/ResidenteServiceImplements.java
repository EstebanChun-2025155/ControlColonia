package com.Administracion.Colonia.Service;

import com.Administracion.Colonia.Entity.Residente;
import com.Administracion.Colonia.Repository.ResidenteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenteServiceImplements implements ResidenteServices {
    private final ResidenteRepository residenteRepository;

    public ResidenteServiceImplements(ResidenteRepository residenteRepository) {
        this.residenteRepository = residenteRepository;
    }

    @Override
    public List<Residente> getAllResidente() { return residenteRepository.findAll();}

    @Override
    public Residente getResidenteById(Integer id) { return residenteRepository.getReferenceById(id); }

    @Override
    public Residente saveResidente(Residente residente) throws RuntimeException {
        try {
            if(residenteRepository.ExistsByNombreResidenteAndDpiResidenteAndTelefonoResidenteAndPosicionAndIdCasa(
                residente.getNomrbe_residente(),
                residente.getDpi_residente(),
                residente.getTelefono_residente(),
                residente.getPosicion(),
                residente.getId_Casa())){

                throw new RuntimeException("Ya existe una casa con estos datos");
            }
                return residenteRepository.save(residente);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Residente updateResidente(Integer id, Residente residente) {
        Residente existingResidente = residenteRepository.findById(id).orElseThrow(()-> new RuntimeException("Esta Casa no existe"));

        if (residenteRepository.ExistsByNombreResidenteAndDpiResidenteAndTelefonoResidenteAndPosicionAndIdCasa(
                residente.getNomrbe_residente(),
                residente.getDpi_residente(),
                residente.getTelefono_residente(),
                residente.getPosicion(),
                residente.getId_Casa())){
            throw new RuntimeException("Ya existe una Casa con estos datos");
        }

        existingResidente.setNomrbe_residente(residente.getNomrbe_residente());
        existingResidente.setDpi_residente(residente.getDpi_residente());
        existingResidente.setTelefono_residente(residente.getTelefono_residente());
        existingResidente.setPosicion(residente.getPosicion());
        existingResidente.setId_Casa(residente.getId_Casa());

        return residenteRepository.save(existingResidente);
    }

    @Override
    public void deleteResidente(Integer id) {
    if(!residenteRepository.existsById(id)){
        throw new RuntimeException("Este id no existe");
        }
        residenteRepository.deleteById(id);
    }
}
