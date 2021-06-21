package com.egg.libreria.mylibreria.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreria.mylibreria.entidades.Editorial;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.repositorios.EditorialRepositorio;

/*
 */
@Service
public class EditorialServicio {
    
    
    @Autowired
    private EditorialRepositorio editorialRepositorio;

    public void crearEditorial(String id, String nombre) throws ExcepcionServicio {

        //validamos los datos
        validar(id, nombre);

        Editorial e1 = new Editorial();
        e1.setId(id);//UUID.randomUUID().toString()
        e1.setNombre(nombre);
        editorialRepositorio.save(e1);

    }

    public void modificarNombreEditorial(String id, String nombre) throws ExcepcionServicio {
        validar(id, nombre);

        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial e1 = respuesta.get();
            e1.setNombre(nombre);
            editorialRepositorio.save(e1);
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }

    }
    //throw siempre que pueda surgir una exception

    public void eliminarEditorial(String id) throws ExcepcionServicio {

        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Editorial e1 = respuesta.get();
            editorialRepositorio.delete(e1);
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }
    }

    public Editorial buscarEditorial(String id) throws ExcepcionServicio{

        Optional<Editorial> respuesta = editorialRepositorio.findById(id);
        if (respuesta.isPresent()) {
            
            return respuesta.get();
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }
    }

    public List<Editorial> listarAutores() {

        return editorialRepositorio.findAll();
    }

    private void validar(String id, String nombre) throws ExcepcionServicio {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar un nombre");
        }

        if (buscarEditorial(id) != null) {
            throw new ExcepcionServicio("el id ya esta registrado en la base de datos");
        }

        if (id == null || id.trim().isEmpty()) {
            throw new ExcepcionServicio("debe ingresar su Id");

        }
    }
}
