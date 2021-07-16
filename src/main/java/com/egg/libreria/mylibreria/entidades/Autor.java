package com.egg.libreria.mylibreria.entidades;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "autor")
public class Autor {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    @NotNull(message = "ingrese su nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "autor")
    private List<Libro> libros;

    public Autor() {
    }
    
    

	public Autor(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
    
}