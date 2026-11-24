package com.jr.gimnasio.service;

import com.jr.gimnasio.model.Socio;
import com.jr.gimnasio.repository.SocioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SocioService {

    private final SocioRepository repository;

    public SocioService(SocioRepository repository) {
        this.repository = repository;
    }

    public List<Socio> listar() {
        return repository.findAll();
    }

    public Socio obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado"));
    }

    public Socio crear(Socio socio) {
        socio.setId(null);
        return repository.save(socio);
    }

    public Socio actualizar(Long id, Socio datos) {
        Socio socio = obtener(id);
        socio.setNombre(datos.getNombre());
        socio.setPlan(datos.getPlan());
        socio.setMensualidad(datos.getMensualidad());
        socio.setActivo(datos.isActivo());
        return repository.save(socio);
    }

    public void eliminar(Long id) {
        obtener(id);
        repository.deleteById(id);
    }

    public double ingresos() {
        return repository.findByActivoTrue().stream()
                .mapToDouble(Socio::getMensualidad)
                .sum();
    }

    public Socio desactivar(Long id) {
        Socio socio = obtener(id);
        if (!socio.isActivo()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "El socio ya estaba inactivo");
        }
        socio.setActivo(false);
        return repository.save(socio);
    }
}
