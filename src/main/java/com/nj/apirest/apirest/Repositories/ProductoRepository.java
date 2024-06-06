package com.nj.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nj.apirest.apirest.Entities.Producto;

//Maneja dos datos: tipo de entidad y tipo de identificador que tiene tipo java
public interface ProductoRepository extends JpaRepository <Producto, Long>{

}
