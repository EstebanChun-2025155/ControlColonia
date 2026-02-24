package com.Administracion.Colonia.Repository;

import com.Administracion.Colonia.Entity.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitasRepository extends JpaRepository<Visitas, Integer> {
}