package com.egg.libreria.mylibreria.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreria.mylibreria.entidades.Autor;
import com.egg.libreria.mylibreria.servicios.AutorServicio;

@RestController
@RequestMapping(path = "/autores")
public class AutorController {
	
	@Autowired
	private AutorServicio autorServicio;
	
	
	@GetMapping(path = "")
	public ResponseEntity<?> listarAutores() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(autorServicio.listarAutores());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PostMapping(path ="")
	public ResponseEntity<?> crearAutor(@Valid @RequestBody Autor autor) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(autorServicio.crearAutor(autor));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<?> obtenerAutorPorId(@PathVariable("id") long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(autorServicio.obtenerAutor(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> eliminarPorId(@PathVariable("id") long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorServicio.eliminarAutor(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PutMapping(path ="/{id}")
	public ResponseEntity<?> editarAutor(@PathVariable("id") long id, @RequestBody Autor autor){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(autorServicio.editarAutor(id, autor));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	

}
