package com.egg.libreria.mylibreria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.egg.libreria.mylibreria.entidades.Libro;
import com.egg.libreria.mylibreria.servicios.LibroServicio;

@RestController
@RequestMapping(path = "libros")
public class LibroController {
	
	@Autowired
	LibroServicio libroServicio;
	
	@GetMapping
	ResponseEntity<?> listarLibros (){
		return ResponseEntity.ok(libroServicio.listarLibros());
	}
	
	@PostMapping(path = "")
	ResponseEntity<?> agregarLibro(@RequestBody Libro libro){
		try {
			return ResponseEntity.status(201).body(libroServicio.crearLibro(libro));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping(path = "/{isbn}")
	ResponseEntity<?> obtenerLibro(@PathVariable("isbn") long isbn){
		try {
			return ResponseEntity.status(200).body(libroServicio.buscarLibro(isbn));
		} catch (Exception e) {
			return ResponseEntity.status(404).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PutMapping(path = "/{isbn}")
	ResponseEntity<?> editarLibro(@PathVariable("isbn") long isbn, @RequestBody Libro libro){
		try {
			return ResponseEntity.status(204).body(libroServicio.modificarLibro(isbn, libro));
		} catch (Exception e) {
			return ResponseEntity.status(404).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	

}
