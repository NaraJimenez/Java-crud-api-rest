package com.nj.apirest.apirest.Controllers;

import java.util.List;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nj.apirest.apirest.Repositories.ProductoRepository;
//Importe de los productos
import com.nj.apirest.apirest.Entities.Producto;


@RestController //CRUD
//URL - Spring (puede ser leido por postman)
@RequestMapping("/productos")

public class ProductoController {
    //SPING - Sabe a que repositorio indicar y hace una instancia de ese REPO
    @Autowired
    private ProductoRepository productoRepository;

    //Get Total - traer todos los productos
    @GetMapping
    public List<Producto> obtenerProductos(){
        return productoRepository.findAll();
    }


    //Get Individual
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id){
        return productoRepository.findById(id)
        //Si no lo encuentra
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));
        //DEVUELVE EL PRODUCTO TAL CUAL LO ENCONTRA
    }

    //Post 
    @PostMapping
    //Tiene que tener los atributos de la entidad - JSON
    public Producto crearProducto(@RequestBody Producto producto){
        return productoRepository.save(producto);
    }

    //Put
    @PutMapping("/{id}")
    //Se pasa el id a modificar, se pasa el path y se actualiza la tabla
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto detallesProducto){
        Producto producto = productoRepository.findById(id)
        //Si no lo encuentra
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));

        //Si se encuentra - Se modifica nombre y precio
        producto.setNombre(detallesProducto.getNombre());
        producto.setPrecio(detallesProducto.getPrecio());

        //Mandamos el producto actualizado, guardado en la BBDD
        return productoRepository.save(producto);
    }


    //Delete
    @DeleteMapping("/{id}")
    public String borrarProducto(@PathVariable Long id){
        //Buscamos y metemos en variable, sino salta el error
        Producto producto = productoRepository.findById(id)
        //Si no lo encuentra
        .orElseThrow(() -> new RuntimeException("No se encontró el producto con el ID: " + id));
        
        //Lo borramos
        productoRepository.delete(producto);

        return "El producto con el ID: " + id + " fue eliminado correctamente";
    
    }


}
