package com.jr.gimnasio.repository;

import com.jr.gimnasio.model.ClaseGrupal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaseGrupalRepository extends JpaRepository<ClaseGrupal, Long> {
    List<ClaseGrupal> findByCuposGreaterThanOrderByCuposDesc(int cupos);
}
