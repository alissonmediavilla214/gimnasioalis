package com.jr.gimnasio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "maquina")
public class Maquina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String marca;
    private int anioCompra;
    private boolean enMantenimiento;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public int getAnioCompra() { return anioCompra; }
    public void setAnioCompra(int anioCompra) { this.anioCompra = anioCompra; }
    public boolean isEnMantenimiento() { return enMantenimiento; }
    public void setEnMantenimiento(boolean enMantenimiento) { this.enMantenimiento = enMantenimiento; }
}
