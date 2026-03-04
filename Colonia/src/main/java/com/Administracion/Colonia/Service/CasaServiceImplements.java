package com.Administracion.Colonia.Service;

import com.Administracion.Colonia.Entity.Casa;
import com.Administracion.Colonia.Repository.CasaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CasaServiceImplements implements CasaService {
    private final CasaRepository casaRepository;

    public CasaServiceImplements(CasaRepository casaRepository) {
        this.casaRepository = casaRepository;
    }

    @Override
    public List<Casa> getAllCasa() { return casaRepository.findAll(); }

    @Override
    public Casa getCasaById(Integer id) { return casaRepository.getReferenceById(id); }

    @Override
    public Casa saveCasa(Casa casa) throws RuntimeException {
        try {
            if (casaRepository.existsByNoDeCasaAndDireccionAndEstadoAndPropietarioAndPrecioCasa(
                    casa.getNoDeCasa(),
                    casa.getDireccion(),
                    casa.getEstado(),
                    casa.getPropietario(),
                    casa.getPrecioCasa())){
                throw new RuntimeException("Ya existe una casa con estos datos");
            }

            return casaRepository.save(casa);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Casa updateCasa(Integer id, Casa casa) {
        Casa existingCasa = casaRepository.findById(id).orElseThrow(() -> new RuntimeException("La casa no existe"));

        if (casaRepository.existsByNoDeCasaAndDireccionAndEstadoAndPropietarioAndPrecioCasa(
                casa.getNoDeCasa(),
                casa.getDireccion(),
                casa.getEstado(),
                casa.getPropietario(),
                casa.getPrecioCasa())){
            throw new RuntimeException("Ya existe una casa con estos datos");
        }

        existingCasa.setNoDeCasa(casa.getNoDeCasa());
        existingCasa.setDireccion(casa.getDireccion());
        existingCasa.setEstado(casa.getEstado());
        existingCasa.setPropietario(casa.getPropietario());
        existingCasa.setPrecioCasa(casa.getPrecioCasa());

        return casaRepository.save(existingCasa);
    }

    @Override
    public void deleteCasa(Integer id) {
        if(!casaRepository.existsById(id)){
            throw new RuntimeException("Este id no existe");
        }
        casaRepository.deleteById(id);
    }
}
