package com.egg.libreria.mylibreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.libreria.mylibreria.entidades.Editorial;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String>{
    
    @Query("SELECT e FROM Editorial e WHERE e.id = :id")
    public Editorial buscarEditorialPorId(@Param("id") String id);
}