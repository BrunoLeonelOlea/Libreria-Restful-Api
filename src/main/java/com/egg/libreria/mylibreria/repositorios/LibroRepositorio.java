package com.egg.libreria.mylibreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.libreria.mylibreria.entidades.Libro;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long>{

    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    public Libro buscarLibroPorIsbn(@Param("isbn") long isbn);
}
