# StephenKingBook

Aplicación de Spring Boot para gestionar y consultar información sobre los libros de Stephen King.

## Descripción

Esta aplicación consume datos de la API de Stephen King, almacena la información en una base de datos MySQL y permite consultar los libros mediante un menú interactivo por consola.

## Tecnologías

- **Java**
- **Spring Boot**
- **Maven**
- **MySQL**
- **JPA/Hibernate**
- **Jackson** (para deserialización JSON)

## Requisitos Previos

- Java 17 o superior
- Maven 3.6+
- MySQL 8.0+
- Variables de entorno configuradas:
  - `DB_HOST`: Host de la base de datos
  - `DB_USER`: Usuario de MySQL
  - `DB_PASSWORD`: Contraseña de MySQL

## Configuración

1. Clonar el repositorio
2. Crear la base de datos en MySQL:
```sql
CREATE DATABASE proyecto_sk;
```

3. Configurar las variables de entorno en tu sistema

## Instalación y Ejecución

```bash
mvn clean install
mvn spring-boot:run
```

## Funcionalidades

La aplicación ofrece un menú interactivo con las siguientes opciones:

1. **Mostrar todos los libros**: Lista todos los libros ordenados por año de publicación (descendente)
2. **Buscar libro por título**: Permite buscar libros por título (búsqueda parcial, case insensitive)
3. **Salir**: Cierra la aplicación

### Carga Automática de Datos

Al iniciar la aplicación, si no hay libros en la base de datos, automáticamente consulta la API de Stephen King y guarda todos los libros disponibles.

## Estructura del Proyecto

- `modelo/`: Clases de dominio (Libro, Villano) y DTOs (Data, DatoLibro, DatoVillano)
- `repositorio/`: Interfaces de repositorio JPA
- `service/`: Servicios para consumo de API
- `principal/`: Lógica principal de la aplicación y menú interactivo

## API Externa

La aplicación consume datos de: `https://stephen-king-api.onrender.com/api/books`

## Autor

Juan Condori (@condorijuan)
