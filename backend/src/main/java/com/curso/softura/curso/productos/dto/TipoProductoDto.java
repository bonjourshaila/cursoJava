package com.curso.softura.curso.productos.dto;

public class TipoProductoDto {
    private Integer idTipoProducto;
    private String nombre;

    public TipoProductoDto() {
        super();
    }

    public TipoProductoDto(Integer idTipoProducto, String nombre) {
        this.idTipoProducto = idTipoProducto;
        this.nombre = nombre;
    }

    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public TipoProductoDto setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoProductoDto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
}
