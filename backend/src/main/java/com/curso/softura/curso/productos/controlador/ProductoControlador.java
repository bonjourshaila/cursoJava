package com.curso.softura.curso.productos.controlador;

import com.curso.softura.curso.general.RespuestaServicio;
import com.curso.softura.curso.productos.dto.ProductoDTO;
import com.curso.softura.curso.productos.dto.TipoProductoDto;
import com.curso.softura.curso.productos.servicio.ProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("api/producto")
public class ProductoControlador implements Serializable {
    private static final long serialVersionUID = 8366742694834006767L;

    private transient Logger log = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private transient ProductoServicio productoServicio;

    @GetMapping("/obtener")
    public ResponseEntity<RespuestaServicio<List<ProductoDTO>>> obtenerProductosActivos(){
        final RespuestaServicio<List<ProductoDTO>> respuesta = new RespuestaServicio<>();

        try {
            List<ProductoDTO> lista = productoServicio.obtenerProductos();
            return respuesta.obtenerRespuesta(lista, "Datos obtenidos correctamente");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }


    @GetMapping("/obtenerTipoProducto")
    public ResponseEntity<RespuestaServicio<List<TipoProductoDto>>> obtenerTipoProductos(){
        final RespuestaServicio<List<TipoProductoDto>> respuesta = new RespuestaServicio<>();

        try {
            List<TipoProductoDto> lista = productoServicio.obtenerTipoProductos();
            return respuesta.obtenerRespuesta(lista, "Datos obtenidos correctamente");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }

    @PostMapping("/guardar")
    public ResponseEntity<RespuestaServicio<Boolean>> guardarProducto(@RequestBody ProductoDTO productoDTO){
        final RespuestaServicio<Boolean> respuesta = new RespuestaServicio<>();
        try {
            boolean res = productoServicio.crearProducto(productoDTO);
            return respuesta.obtenerRespuesta(res, "Datos obtenidos correctamente");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }

    @DeleteMapping("/eliminar")
    public ResponseEntity<RespuestaServicio<Boolean>> eliminarProducto(@RequestParam Long idProducto){
        final RespuestaServicio<Boolean> respuesta = new RespuestaServicio<>();
        try {
            boolean res = productoServicio.deleteRegistro(idProducto);
            return respuesta.obtenerRespuesta(res, "Datos obtenidos correctamente");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }




    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*");
            }

        };
    }



}
