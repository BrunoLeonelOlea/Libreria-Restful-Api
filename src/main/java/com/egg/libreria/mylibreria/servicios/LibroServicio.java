package com.egg.libreria.mylibreria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreria.mylibreria.entidades.Libro;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.repositorios.LibroRepositorio;

//servicios = reglas de negocio = crud
@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    public void crearLibro(long isbn, String titulo, int anio, int ejemplares, int prestados) throws Exception {
        
        Libro libro = new Libro();

        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnio(anio);
        libro.setEjemplares(ejemplares);
        libro.setPrestados(prestados);

        libroRepositorio.save(libro);

    }

    public void modificarLibro(long isbn, String titulo, int anio, int ejemplares, int prestados) throws ExcepcionServicio {


        Optional<Libro> oLibro = libroRepositorio.findById(isbn);
        if (oLibro.isPresent()) {
            Libro libro = oLibro.get();
            
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setPrestados(prestados);

            libroRepositorio.save(libro);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun libro en la base de datos");
        }

    }
    
    public void eliminarLibro(long isbn) throws ExcepcionServicio{
        
        Optional<Libro> oLibro = libroRepositorio.findById(isbn);
        if (oLibro.isPresent()) {
            Libro libro = oLibro.get();

            libroRepositorio.delete(libro);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun libro en la base de datos");
        }

    }

    // por el ID
    public Libro buscarLibro(long isbn) throws ExcepcionServicio{
        
        Optional<Libro> oLibro = libroRepositorio.findById(isbn);
        if (oLibro.isPresent()) {
            Libro libro = oLibro.get();
            return libro;
        } else{
            throw new ExcepcionServicio("El id no esta relacionado a ningun libro en la base de datos");
        }
    }


    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

   

}