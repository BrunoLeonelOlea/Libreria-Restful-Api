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

    public void modificarNombreAutor(Long id, String nombre) throws ExcepcionServicio {

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor a1 = respuesta.get();
            a1.setNombre(nombre);
            autorRepositorio.save(a1);
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }

    }

    public void eliminarAutor(Long id) throws ExcepcionServicio {

        Optional<Autor> respuesta = autorRepositorio.findById(id);
        if (respuesta.isPresent()) {
            Autor a1 = respuesta.get();
            autorRepositorio.delete(a1);
        } else {
            throw new ExcepcionServicio("no se encontro el Autor");
        }
    }

    public Autor buscarAutor(Long id) throws ExcepcionServicio{

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

}