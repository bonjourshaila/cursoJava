package com.curso.softura.curso.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "c_tipo_producto")
public class TipoProducto extends BitacoraModelo implements Serializable {

    private static final long serialVersionUID = -8221436353130121090L;
    @Id
    @Column
    private Integer idTipoProducto;

    @Column
    private String tipoProducto;


    @OneToMany(mappedBy = "tipoProducto", fetch = FetchType.LAZY)
    private Set<Producto> productos;


    public Integer getIdTipoProducto() {
        return idTipoProducto;
    }

    public TipoProducto setIdTipoProducto(Integer idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        return this;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public TipoProducto setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
        return this;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
