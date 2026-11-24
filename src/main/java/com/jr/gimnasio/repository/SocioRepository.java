package com.jr.gimnasio.repository;

import com.jr.gimnasio.model.Socio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocioRepository extends JpaRepository<Socio, Long> {
    List<Socio> findByActivoTrue();
}
