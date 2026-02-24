package com.Administracion.Colonia.Service;


import com.Administracion.Colonia.Entity.Visitas;
import com.Administracion.Colonia.Repository.VisitasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitasServiceImplementes implements VisitasService{

    private final VisitasRepository visitasRepository;

    public VisitasServiceImplementes(VisitasRepository visitasRepository) {
        this.visitasRepository = visitasRepository;
    }

    @Override
    public List<Visitas> getAllVisitas() {
        return visitasRepository.findAll();
    }

    @Override
    public Visitas getVisitasById(Integer id) {
        Visitas visitas = visitasRepository.findById(id).orElse(null);
        if(visitas == null) {
            throw new IllegalArgumentException("Visita no encontrada");
        }
        return visitasRepository.findById(id).orElse(null);
    }

    @Override
    public Visitas saveVisitas(Visitas visitas) throws RuntimeException {
        return visitasRepository.save(visitas);
    }

    @Override
    public Visitas updateVisitas(Integer id, Visitas visitas) {
        return null;
    }

    @Override
    public void deleteVisitas(Integer id) {

    }
}
