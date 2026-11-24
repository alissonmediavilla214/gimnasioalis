package com.jr.gimnasio.controller;

import com.jr.gimnasio.model.Maquina;
import com.jr.gimnasio.service.MaquinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maquina")
public class MaquinaController {

    private final MaquinaService service;

    public MaquinaController(MaquinaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Maquina> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Maquina obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<Maquina> crear(@RequestBody Maquina maquina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(maquina));
    }

    @PutMapping("/{id}")
    public Maquina actualizar(@PathVariable Long id, @RequestBody Maquina maquina) {
        return service.actualizar(id, maquina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/operativas")
    public List<Maquina> operativas() {
        return service.operativas();
    }

    @GetMapping("/antiguas")
    public List<Maquina> antiguas(@RequestParam int anios) {
        return service.antiguas(anios);
    }

    @PutMapping("/{id}/mantenimiento")
    public Maquina mantenimiento(@PathVariable Long id) {
        return service.enviarAMantenimiento(id);
    }
}
