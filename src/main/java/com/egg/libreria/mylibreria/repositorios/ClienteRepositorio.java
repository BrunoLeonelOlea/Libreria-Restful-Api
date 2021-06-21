package com.egg.libreria.mylibreria.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egg.libreria.mylibreria.entidades.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    
    @Query("SELECT c FROM Cliente c WHERE c.documento = :documento")
    public Cliente buscarClientePorDocumento(@Param("documento")long documento);
}
