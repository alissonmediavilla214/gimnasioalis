package com.jr.gimnasio.service;

import com.jr.gimnasio.model.ClaseGrupal;
import com.jr.gimnasio.repository.ClaseGrupalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClaseGrupalService {

    private final ClaseGrupalRepository repository;

    public ClaseGrupalService(ClaseGrupalRepository repository) {
        this.repository = repository;
    }

    public List<ClaseGrupal> listar() {
        return repository.findAll();
    }

    public ClaseGrupal obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clase no encontrada"));
    }

    public ClaseGrupal crear(ClaseGrupal clase) {
        clase.setId(null);
        return repository.save(clase);
    }

    public ClaseGrupal actualizar(Long id, ClaseGrupal datos) {
        ClaseGrupal clase = obtener(id);
        clase.setNombre(datos.getNombre());
        clase.setInstructor(datos.getInstructor());
        clase.setHorario(datos.getHorario());
        clase.setCupos(datos.getCupos());
        return repository.save(clase);
    }

    public void eliminar(Long id) {
        obtener(id);
        repository.deleteById(id);
    }

    public ClaseGrupal inscribir(Long id) {
        ClaseGrupal clase = obtener(id);
        if (clase.getCupos() <= 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "No quedan cupos en la clase");
        }
        clase.setCupos(clase.getCupos() - 1);
        return repository.save(clase);
    }

    public ClaseGrupal cancelarInscripcion(Long id) {
        ClaseGrupal clase = obtener(id);
        clase.setCupos(clase.getCupos() + 1);
        return repository.save(clase);
    }

    public List<ClaseGrupal> conCupos() {
        return repository.findByCuposGreaterThanOrderByCuposDesc(0);
    }
}
