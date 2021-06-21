package com.egg.libreria.mylibreria.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreria.mylibreria.entidades.Autor;
import com.egg.libreria.mylibreria.servicios.AutorServicio;

@RestController
@RequestMapping(path = "/autor/v0.1.0")
public class AutorController {
	
	@Autowired
	private AutorServicio autorServicio;
	
	
	@GetMapping(path = "/all")
	public List<Autor> listarAutores() {
		return autorServicio.listarAutores();
	}
	
	@PostMapping(path ="/new")
	public Autor crearAutor(@Valid @RequestBody Autor autor) {
		return this.autorServicio.crearAutor(autor);
	}
	
	

}
