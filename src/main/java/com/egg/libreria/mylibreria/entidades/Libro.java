package com.egg.libreria.mylibreria.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

@Entity
public class Libro implements Serializable {

    @Id
    private long isbn;

    @NotBlank(message = "ingrese un titulo")
    private String titulo;

    @Past
    private int anio;

    @Positive
    private int ejemplares;

    @Positive
    private int prestados;

    @ManyToOne
    private Autor autor;
    @ManyToOne
    private Editorial editorial;

    public Libro() {
    }

    public Libro(long isbn, String titulo, int anio, int ejemplares, int prestados, Autor autor, Editorial editorial) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.prestados = prestados;
        this.autor = autor;
        this.editorial = editorial;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(int ejemplares) {
        this.ejemplares = ejemplares;
    }

    public int getPrestados() {
        return prestados;
    }

    public void setPrestados(int prestados) {
        this.prestados = prestados;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

}