package com.jr.gimnasio.controller;

import com.jr.gimnasio.model.Socio;
import com.jr.gimnasio.service.SocioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/socio")
public class SocioController {

    private final SocioService service;

    public SocioController(SocioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Socio> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Socio obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<Socio> crear(@RequestBody Socio socio) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(socio));
    }

    @PutMapping("/{id}")
    public Socio actualizar(@PathVariable Long id, @RequestBody Socio socio) {
        return service.actualizar(id, socio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ingresos")
    public Map<String, Double> ingresos() {
        return Map.of("ingresos", service.ingresos());
    }

    @PutMapping("/{id}/desactivar")
    public Socio desactivar(@PathVariable Long id) {
        return service.desactivar(id);
    }
}
