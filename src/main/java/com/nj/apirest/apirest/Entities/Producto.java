package com.nj.apirest.apirest.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Marcar que es una entidad
@Entity

public class Producto {
    //Identificador unico de cada producto - ELEMENTOS SPRING
    //Clave primaria(autognenere y autonicremental)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Metemos el atributo que queremos meter
    private Long id;
    private String nombre;
    private double precio;

    //GETTERS y SETTERS
    // --ID--
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

    // --Nombre--
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

    // --Precio--
        public double getPrecio() {
            return precio;
        }
        public void setPrecio(double precio) {
            this.precio = precio;
        }

    
}
