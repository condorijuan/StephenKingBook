package com.Juan.StephenKingBook.repositorio;

import com.Juan.StephenKingBook.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Libro, Long> {

    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    @Query(value = "SELECT * FROM libro ORDER BY anio_publicacion DESC", nativeQuery = true)
    List<Libro> buscarTodosLosLibros();
}
