package com.architechz.project.packageservices.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "bodega")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String direccion;

    @NotBlank
    private double capacidad;

    @NotBlank
    private String tipo;

    @OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Mercancia> inventario;

    public Bodega() {
        this.inventario = new ArrayList<>();
    }

    public Bodega(Long id, @NotBlank String direccion, @NotBlank double capacidad, @NotBlank String tipo) {
        this.id = id;
        this.direccion = direccion;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.inventario = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
