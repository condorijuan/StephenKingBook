package com.Juan.StephenKingBook.modelo;

import jakarta.persistence.*;

@Entity
public class Villano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne()
    private Libro libro;

    public Villano() {
    }

    public Villano(DatoVillano dv) {
        this.nombre = dv.nombre();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return ", nombre= " + nombre;
    }
}
