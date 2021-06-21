package com.egg.libreria.mylibreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.libreria.mylibreria.entidades.Autor;

/*
 */
@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String>{

//    @Query("SELECT a FROM Autor a WHERE a.id = :id")
//    public Autor buscarAutorPorId(@Param("id") String Id);
	
}
