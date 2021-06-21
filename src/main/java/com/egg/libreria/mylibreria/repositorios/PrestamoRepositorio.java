package com.egg.libreria.mylibreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.libreria.mylibreria.entidades.Prestamo;

@Repository
public interface PrestamoRepositorio extends JpaRepository<Prestamo, String>{
    
    @Query("SELECT p FROM Prestamo p WHERE p.id = :id")
    public Prestamo buscarPrestamoPorId(@Param("id")String id);

}