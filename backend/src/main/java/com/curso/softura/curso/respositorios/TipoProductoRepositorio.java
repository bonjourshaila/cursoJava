package com.curso.softura.curso.respositorios;

import com.curso.softura.curso.modelos.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepositorio  extends JpaRepository<TipoProducto, Integer> {
}
