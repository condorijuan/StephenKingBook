package com.Juan.StephenKingBook.principal;

import com.Juan.StephenKingBook.modelo.Data;
import com.Juan.StephenKingBook.modelo.DatoLibro;
import com.Juan.StephenKingBook.modelo.Libro;
import com.Juan.StephenKingBook.repositorio.Repository;
import com.Juan.StephenKingBook.service.ConsumoApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConvertirDatos convertirDatos = new ConvertirDatos();
    private ArrayList<Libro> listaLibros = new ArrayList<>();
    private Repository repository;
    private String urlApi = "https://stephen-king-api.onrender.com/api/books";
    private Scanner scanner = new Scanner(System.in);

    public Principal(Repository repository) {
        this.repository = repository;
    }

    public void mostrarMenu(){
        System.out.println("Bienvenido al sistema de libros de Stephen King");
        verificarDatosGuardados();
        var opcion = -1;
        while (opcion != 3) {
            opcionesMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listaTodosLibros();
                    break;
                case 2:
                    buscarXTitulo();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intente de nuevo.");
            }
        }

    }

    private void buscarXTitulo() {
        System.out.println("Ingrese el titulo del libro a buscar: ");
        scanner.nextLine(); // Limpiar el buffer
        String tituloBuscado = scanner.nextLine();
        List<Libro> librosEncontrados = repository.findByTituloContainingIgnoreCase(tituloBuscado);
        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con el titulo: " + tituloBuscado);
        } else {
            System.out.println("Libros encontrados:");
            librosEncontrados.forEach(l -> System.out.println("titulo: " + l.getTitulo() + ", Año Publicacion: " + l.getAnioPublicacion() +
                    ", Editorial: " + l.getEditorial()));
        }
    }

    private void listaTodosLibros() {
        List<Libro> listadoLibro = repository.buscarTodosLosLibros();
        listadoLibro.forEach(l -> System.out.println("Titulo: " + l.getTitulo() + ", Año Publicacion: " + l.getAnioPublicacion()));
    }

    //Verificar que haya datos guardados en la base de datos
    public void verificarDatosGuardados() {
        long count = repository.count();
        if (count > 0) {
            System.out.println("Hay " + count + " libros guardados en la base de datos ");
        } else {
            System.out.println("No hay libros guardados en la base de datos ");
            ObtenerLibroAPI();
            System.out.println("Libros obtenidos y guardados en la base de datos ");
        }
    }

    public void ObtenerLibroAPI(){
        var json = consumoApi.obtenerDatos(urlApi);
        Data datos = convertirDatos.obtenerDatos(json , Data.class);
        System.out.println("Libro obtenido: " + datos);

        listaLibros = datos.datoLibros().stream()
                .map(l -> new Libro(
                                l.anioPublicacion(),
                                l.titulo(),
                                l.editorial(),
                                l.isbn(),
                                l.paginas(),
                                l.villano()
                        )
                )
                .collect(Collectors.toCollection(ArrayList::new));

        repository.saveAll(listaLibros);
    }

    public void opcionesMenu(){
        System.out.println("Opciones del menu:");
        System.out.println("1. Mostrar todos los libros");
        System.out.println("2. Buscar libro por titulo");
        System.out.println("3. Salir");
    }

}
