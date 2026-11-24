package com.jr.gimnasio.repository;

import com.jr.gimnasio.model.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaquinaRepository extends JpaRepository<Maquina, Long> {
    List<Maquina> findByEnMantenimientoFalse();
    List<Maquina> findByAnioCompraLessThan(int anio);
}
