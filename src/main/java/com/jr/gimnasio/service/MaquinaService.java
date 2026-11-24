package com.jr.gimnasio.service;

import com.jr.gimnasio.model.Maquina;
import com.jr.gimnasio.repository.MaquinaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Year;
import java.util.List;

@Service
public class MaquinaService {

    private final MaquinaRepository repository;

    public MaquinaService(MaquinaRepository repository) {
        this.repository = repository;
    }

    public List<Maquina> listar() {
        return repository.findAll();
    }

    public Maquina obtener(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Máquina no encontrada"));
    }

    public Maquina crear(Maquina maquina) {
        maquina.setId(null);
        return repository.save(maquina);
    }

    public Maquina actualizar(Long id, Maquina datos) {
        Maquina maquina = obtener(id);
        maquina.setNombre(datos.getNombre());
        maquina.setMarca(datos.getMarca());
        maquina.setAnioCompra(datos.getAnioCompra());
        maquina.setEnMantenimiento(datos.isEnMantenimiento());
        return repository.save(maquina);
    }

    public void eliminar(Long id) {
        obtener(id);
        repository.deleteById(id);
    }

    public List<Maquina> operativas() {
        return repository.findByEnMantenimientoFalse();
    }

    // Más de "anios" años desde la compra: añoActual - anioCompra > anios
    public List<Maquina> antiguas(int anios) {
        int limite = Year.now().getValue() - anios;
        return repository.findByAnioCompraLessThan(limite);
    }

    public Maquina enviarAMantenimiento(Long id) {
        Maquina maquina = obtener(id);
        if (maquina.isEnMantenimiento()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La máquina ya estaba en mantenimiento");
        }
        maquina.setEnMantenimiento(true);
        return repository.save(maquina);
    }
}
