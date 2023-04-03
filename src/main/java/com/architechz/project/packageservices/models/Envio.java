package com.architechz.project.packageservices.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.architechz.project.packageservices.enums.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "envio")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String origen;

    @NotBlank
    private String destino;

    @NotBlank
    private Date fechaSalida;

    @NotBlank
    private BigDecimal costoTonelada;

    @NotBlank
    private BigDecimal costoViaje;

    @NotBlank
    private Estado estado;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Mercancia> articulos;

    public Envio() {
    }

    public Envio(Long id, @NotBlank String origen, @NotBlank String destino, @NotBlank Date fechaSalida,
            @NotBlank BigDecimal costoTonelada, @NotBlank BigDecimal costoViaje, @NotBlank Estado estado) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.costoTonelada = costoTonelada;
        this.costoViaje = costoViaje;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public BigDecimal getCostoTonelada() {
        return costoTonelada;
    }

    public void setCostoTonelada(BigDecimal costoTonelada) {
        this.costoTonelada = costoTonelada;
    }

    public BigDecimal getCostoViaje() {
        return costoViaje;
    }

    public void setCostoViaje(BigDecimal costoViaje) {
        this.costoViaje = costoViaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
}
