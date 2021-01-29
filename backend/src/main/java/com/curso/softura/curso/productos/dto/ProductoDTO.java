package com.curso.softura.curso.productos.dto;

import java.io.Serializable;

public class ProductoDTO implements Serializable {

    private static final long serialVersionUID = 5618541332556323433L;
    private Long idProducto;
    private String nombre;
    private Integer idTipoProducto;
    private Boolean activo;


    public ProductoDTO() {
        super();
    }

    public ProductoDTO(Long idProducto, String nombre, Integer idTipoProducto, Boolean activo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idTipoProducto = idTipoProducto;
        this.activo = activo;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public ProductoDTO setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public ProductoDTO setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public ProductoDTO setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        return this;
    }

    public Boolean getActivo() {
        return activo;
    }

    public ProductoDTO setActivo(Boolean activo) {
        this.activo = activo;
        return this;
    }

}


