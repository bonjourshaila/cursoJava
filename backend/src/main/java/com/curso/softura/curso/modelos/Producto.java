package com.curso.softura.curso.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "m_producto")
public class Producto extends BitacoraModelo implements Serializable{

    private static final long serialVersionUID = -7475526049448108474L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idProducto;

    @Column
    private String nombre;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_producto")
    private TipoProducto tipoProducto;

    public Long getIdProducto() {
        return idProducto;
    }

    public Producto setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public Producto setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }





}
