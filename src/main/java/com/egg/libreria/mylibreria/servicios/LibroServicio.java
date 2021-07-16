package com.egg.libreria.mylibreria.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreria.mylibreria.entidades.Libro;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.repositorios.LibroRepositorio;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;
    
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    public Libro crearLibro(Libro libro) throws Exception {
        return libroRepositorio.save(libro);
    }

    public Libro modificarLibro(long isbn, Libro libro) throws ExcepcionServicio {

        Optional<Libro> oLibro = libroRepositorio.findById(isbn);
        if (oLibro.isPresent()) {
            Libro libro1 = oLibro.get();
            
            libro1.setTitulo(libro.getTitulo());
            libro1.setAnio(libro.getAnio());
            libro1.setEjemplares(libro.getEjemplares());
            libro1.setPrestados(libro.getPrestados());

            return libroRepositorio.save(libro);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun libro en la base de datos");
        }

    }

    public Libro buscarLibro(long isbn) throws ExcepcionServicio{
        
        Optional<Libro> oLibro = libroRepositorio.findById(isbn);
        if (oLibro.isPresent()) {
            Libro libro = oLibro.get();
            return libro;
        } else{
            throw new ExcepcionServicio("El id no esta relacionado a ningun libro en la base de datos");
        }
    }


   

//  public void eliminarLibro(long isbn) throws ExcepcionServicio{
//  
//  Optional<Libro> oLibro = libroRepositorio.findById(isbn);
//  if (oLibro.isPresent()) {
//      Libro libro = oLibro.get();
//
//      libroRepositorio.delete(libro);
//  } else {
//      throw new ExcepcionServicio("El id no esta relacionado a ningun libro en la base de datos");
//  }
//
//}

}