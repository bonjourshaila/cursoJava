package com.curso.softura.curso.modelos;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
public class BitacoraModelo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "fecha_alta")
    protected ZonedDateTime fechaAlta;

    @Column(name = "fecha_modificacion")
    protected ZonedDateTime fechaModificacion;

    @Column(name = "usuario_alta")
    protected Long usuarioAlta;

    @Column(name = "usuario_modificacion")
    protected Long usuarioModificacion;

    @Column(name = "registro_activo")
    protected Boolean registroActivo;

    public ZonedDateTime getFechaAlta() {
        return fechaAlta;
    }

    public BitacoraModelo setFechaAlta(ZonedDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
        return this;
    }

    public ZonedDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public BitacoraModelo setFechaModificacion(ZonedDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
        return this;
    }

    public Long getUsuarioAlta() {
        return usuarioAlta;
    }

    public BitacoraModelo setUsuarioAlta(Long usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
        return this;
    }

    public Long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public BitacoraModelo setUsuarioModificacion(Long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
        return this;
    }

    public Boolean getRegistroActivo() {
        return registroActivo;
    }

    public BitacoraModelo setRegistroActivo(Boolean registroActivo) {
        this.registroActivo = registroActivo;
        return this;
    }
}
