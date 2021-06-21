package com.egg.libreria.mylibreria.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Prestamo implements Serializable {

    @Id
    private String id;

    @Temporal(TemporalType.DATE)
    @PastOrPresent
    private Date fecha;

    @Temporal(TemporalType.DATE)
    @Future
    private Date devolucion;
    
    @ManyToOne
    private Libro libro;
    @ManyToOne
    private Cliente cliente;

    public Prestamo() {
    }

    public Prestamo(String id, Date fecha, Date devolucion, Libro libro, Cliente cliente) {
        this.id = id;
        this.fecha = fecha;
        this.devolucion = devolucion;
        this.libro = libro;
        this.cliente = cliente;
    }

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Date devolucion) {
        this.devolucion = devolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fecha=" + fecha + ", devolucion=" + devolucion + ", libro=" + libro + ", cliente=" + cliente + '}';
    }
    
    

}
