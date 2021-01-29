package com.curso.softura.curso.productos.servicio;

import com.curso.softura.curso.helper.FechasHelper;
import com.curso.softura.curso.modelos.Producto;
import com.curso.softura.curso.modelos.TipoProducto;
import com.curso.softura.curso.productos.dto.ProductoDTO;
import com.curso.softura.curso.productos.dto.TipoProductoDto;
import com.curso.softura.curso.respositorios.ProductoRepositorio;
import com.curso.softura.curso.respositorios.TipoProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductoServicio implements Serializable {
    private static final long serialVersionUID = 5587697424738022135L;

    @Autowired
    private transient ProductoRepositorio productoRepositorio;

    @Autowired
    private transient TipoProductoRepositorio tipoProductoRepositorio;

    public List<ProductoDTO> obtenerProductos(){
        List<Producto> lista = productoRepositorio.findAll();


        return lista.stream().map(producto ->
                new ProductoDTO(producto.getIdProducto(),producto.getNombre(),producto.getTipoProducto().getIdTipoProducto(),producto.getRegistroActivo())
        ).collect(Collectors.toList());

//        List<ProductoDTO> respuesta = new ArrayList<>();
//
//        for (Producto producto: lista) {
//            respuesta.add( new ProductoDTO(producto.getIdProducto(),producto.getNombre()));
//        }
//
//        return respuesta;

    }


    public List<TipoProductoDto> obtenerTipoProductos(){
        List<TipoProducto> lista = tipoProductoRepositorio.findAll();

        return lista.stream().map(tipoProducto ->
                new TipoProductoDto(tipoProducto.getIdTipoProducto(),tipoProducto.getTipoProducto())
        ).collect(Collectors.toList());


    }

    public Boolean crearProducto( ProductoDTO productoDto){
        Producto producto = new Producto();

        Optional<TipoProducto> tipoProducto = tipoProductoRepositorio.findById(productoDto.getIdTipoProducto());

        if (!tipoProducto.isPresent()){ return false; }

        if (productoDto.getIdProducto() !=  null){
            producto = productoRepositorio.findById(productoDto.getIdProducto()).get();
        }else {
            producto.setFechaAlta(FechasHelper.obtenerFechaActual());
            producto.setUsuarioAlta((long) 1);
        }



        producto.setNombre(productoDto.getNombre());
        producto.setTipoProducto(tipoProducto.get());

        producto.setFechaModificacion(FechasHelper.obtenerFechaActual());

        producto.setUsuarioModificacion((long) 1);
        producto.setRegistroActivo(true);

        productoRepositorio.save(producto);

        return true;

    }

    public Boolean deleteRegistro(Long id){
        Optional<Producto> datos = productoRepositorio.findById(id);

        if (!datos.isPresent()){ return  false;}

        datos.get().setRegistroActivo(!datos.get().getRegistroActivo());
        datos.get().setFechaModificacion(FechasHelper.obtenerFechaActual());
        datos.get().setUsuarioModificacion((long) 1);

        productoRepositorio.save(datos.get());

        return true;

    }

}
