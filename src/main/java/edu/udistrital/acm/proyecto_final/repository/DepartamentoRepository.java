package edu.udistrital.acm.proyecto_final.repository;

import edu.udistrital.acm.proyecto_final.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}

