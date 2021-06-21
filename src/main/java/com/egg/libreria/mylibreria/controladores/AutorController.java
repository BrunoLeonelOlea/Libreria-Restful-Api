package com.egg.libreria.mylibreria.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreria.mylibreria.entidades.Autor;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.servicios.AutorServicio;

@RestController
@RequestMapping(path = "/autor")
public class AutorController {
	
	@Autowired
	private AutorServicio autorServicio;
	
	public AutorController(AutorServicio autorServicio) {
		this.autorServicio = autorServicio;
	}
	
	@GetMapping(path = "/all")
	public List<Autor> listarAutores() {
		return autorServicio.listarAutores();
	}
	
	@PostMapping(path ="/new")
	public void crearAutor(String id, String nombre) {
		autorServicio.crearAutor(id, nombre);
	}

}
