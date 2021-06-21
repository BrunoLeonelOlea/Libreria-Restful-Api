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

    public void crearAutor(String id, String nombre) {

        Autor a1 = new Autor();
        a1.setId(id);//UUID.randomUUID().toString()
        a1.setNombre(nombre);
        autorRepositorio.save(a1);

    }

    public void modificarNombreAutor(String id, String nombre) throws ExcepcionServicio {
        validar(id, nombre);

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor a1 = respuesta.get();
            a1.setNombre(nombre);
            autorRepositorio.save(a1);
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }

    }

    public void eliminarAutor(String id) throws ExcepcionServicio {

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor a1 = respuesta.get();
            autorRepositorio.delete(a1);
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }
    }

    public Autor buscarAutor(String id) throws ExcepcionServicio{

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            
            return respuesta.get();
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }
    }

    public List<Autor> listarAutores() {

        return autorRepositorio.findAll();
    }

    private void validar(String id, String nombre) throws ExcepcionServicio {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar un nombre");
        }

        if (buscarAutor(id) != null) {
            throw new ExcepcionServicio("el id ya esta registrado en la base de datos");
        }

        if (id == null || id.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar su Id");

        }
    }
}