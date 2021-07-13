package com.egg.libreria.mylibreria.servicios;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreria.mylibreria.entidades.Autor;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.repositorios.AutorRepositorio;

@Service
public class AutorServicio {

	@Autowired
	private AutorRepositorio autorRepositorio;

	public Autor crearAutor(Autor autor) {

		return autorRepositorio.save(autor);
	}

	public Autor editarAutor(Long id, Autor autor) throws Exception{
		try {
			Optional<Autor> autorOpcional = autorRepositorio.findById(id);
			Autor autor1 = autorOpcional.get();
			autor1 = autorRepositorio.save(autor);
			return autor1;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		

	}

	public boolean eliminarAutor(Long id) throws Exception{

		try {

			if(autorRepositorio.existsById(id)) {
				autorRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Autor obtenerAutor(Long id) throws Exception{

		try {
			Optional<Autor> autorOptional = autorRepositorio.findById(id);
			return autorOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<Autor> listarAutores() {

		return autorRepositorio.findAll();
	}

}