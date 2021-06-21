package com.egg.libreria.mylibreria.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egg.libreria.mylibreria.entidades.Cliente;
import com.egg.libreria.mylibreria.entidades.Libro;
import com.egg.libreria.mylibreria.entidades.Prestamo;
import com.egg.libreria.mylibreria.excepciones.ExcepcionServicio;
import com.egg.libreria.mylibreria.repositorios.PrestamoRepositorio;

/*
 */
@Service
public class PrestamoServicio {

    @Autowired
    private PrestamoRepositorio prestamoRepositorio;

    public void crearPrestamo(String id, Date fecha, Date devolucion, Libro libro, Cliente cliente) throws Exception {

        Prestamo prestamo = new Prestamo();

        prestamo.setId(id);
        prestamo.setFecha(fecha);
        prestamo.setDevolucion(devolucion);
        prestamo.setLibro(libro);
        prestamo.setCliente(cliente);

        prestamoRepositorio.save(prestamo);

    }

    public void modificarPrestamo(String id, Date fecha, Date devolucion, Libro libro, Cliente cliente) throws ExcepcionServicio {

        Optional<Prestamo> oPrestamo = prestamoRepositorio.findById(id);
        if (oPrestamo.isPresent()) {
            Prestamo prestamo = oPrestamo.get();

            prestamo.setFecha(fecha);
            prestamo.setDevolucion(devolucion);
            prestamo.setLibro(libro);
            prestamo.setCliente(cliente);
            prestamoRepositorio.save(prestamo);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun prestamo en la base de datos");
        }

    }

    public void eliminarPrestamo(String id) throws ExcepcionServicio {

        Optional<Prestamo> oPrestamo = prestamoRepositorio.findById(id);
        if (oPrestamo.isPresent()) {
            Prestamo prestamo = oPrestamo.get();

            prestamoRepositorio.delete(prestamo);
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun prestamo en la base de datos");
        }

    }

    // por el ID
    public Prestamo buscarPrestamo(String id) throws ExcepcionServicio {

        Optional<Prestamo> oPrestamo = prestamoRepositorio.findById(id);
        if (oPrestamo.isPresent()) {
            Prestamo prestamo = oPrestamo.get();
            return prestamo;
        } else {
            throw new ExcepcionServicio("El id no esta relacionado a ningun prestamo en la base de datos");
        }
    }

    public List<Prestamo> listarPrestamos() {
        return prestamoRepositorio.findAll();
    }
}