package com.egg.libreria.mylibreria.controllers;

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

import com.egg.libreria.mylibreria.entidades.Cliente;
import com.egg.libreria.mylibreria.servicios.ClienteServicio;

@RestController
@RequestMapping(path = "/clients")
public class ClienteController {
	
	@Autowired
	ClienteServicio clienteServicio;
	
	@GetMapping(path = "")
	ResponseEntity<?> listarClientes(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(clienteServicio.listarClientes());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@GetMapping(path = "/{id}")
	ResponseEntity<?> obtenerCliente(@PathVariable ("id") long id){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(clienteServicio.buscarCliente(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PostMapping(path = "")
	ResponseEntity<?> addCliente(@RequestBody Cliente cliente){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteServicio.crearCliente(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@PutMapping(path = "/{id}")
	ResponseEntity<?> editarCliente(@PathVariable ("id") long id, @RequestBody Cliente cliente){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteServicio.modificarCliente(id, cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}
	
	@DeleteMapping(path = "/{id}")
	ResponseEntity<?> eliminarCliente(@PathVariable ("id") long id){
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(clienteServicio.eliminarCliente(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"" + e.getMessage() + "\"}");
		}
	}

}
