package com.architechz.project.packageservices.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mercancia")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    private double peso;

    @NotBlank
    private double volumen;

    @NotBlank
    private String ubicacion;

    @NotBlank
    private String tipo;

    @ManyToOne
    @JsonIgnore
    private Bodega bodega;

    @ManyToOne
    @JsonIgnore
    private Envio envio;

    public Mercancia() {
    }

    public Mercancia(Long id, @NotBlank double peso, @NotBlank double volumen, @NotBlank String ubicacion,
            @NotBlank String tipo) {
        this.id = id;
        this.peso = peso;
        this.volumen = volumen;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
