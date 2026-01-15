package com.Juan.StephenKingBook.modelo;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String anioPublicacion;
    private String titulo;
    private String editorial;
    private String isbn;
    private String paginas;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Villano> villano;

    public Libro(String anio, String titulo, String editorial, String isbn, String paginas, List<DatoVillano> Datavillano) {
        this.anioPublicacion = anio;
        this.titulo = titulo;
        this.editorial = editorial;
        this.isbn = isbn;
        this.paginas = paginas;
        setVillano(Datavillano);
    }

    public Libro() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(String anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public List<Villano> getVillano() {
        return villano;
    }

    public void setVillano(List<DatoVillano> villano) {
        List<Villano> villanos = villano.stream().map(dv -> new Villano(dv)).toList();
        villanos.forEach(v -> v.setLibro(this));
        this.villano = villanos;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", anioPublicacion='" + anioPublicacion + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", isbn='" + isbn + '\'' +
                ", paginas='" + paginas + '\'' +
                ", villano=" + villano.toString() +
                '}';
    }
}
