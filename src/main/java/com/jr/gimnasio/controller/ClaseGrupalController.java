package com.jr.gimnasio.controller;

import com.jr.gimnasio.model.ClaseGrupal;
import com.jr.gimnasio.service.ClaseGrupalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clase")
public class ClaseGrupalController {

    private final ClaseGrupalService service;

    public ClaseGrupalController(ClaseGrupalService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClaseGrupal> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ClaseGrupal obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<ClaseGrupal> crear(@RequestBody ClaseGrupal clase) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(clase));
    }

    @PutMapping("/{id}")
    public ClaseGrupal actualizar(@PathVariable Long id, @RequestBody ClaseGrupal clase) {
        return service.actualizar(id, clase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/inscribir")
    public ClaseGrupal inscribir(@PathVariable Long id) {
        return service.inscribir(id);
    }

    @PutMapping("/{id}/cancelar-inscripcion")
    public ClaseGrupal cancelarInscripcion(@PathVariable Long id) {
        return service.cancelarInscripcion(id);
    }

    @GetMapping("/con-cupos")
    public List<ClaseGrupal> conCupos() {
        return service.conCupos();
    }
}
