package com.Juan.StephenKingBook.modelo;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.api.client.json.Json;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoLibro(
        @JsonAlias("Year") String anioPublicacion,
        @JsonAlias("Title") String titulo,
        @JsonAlias("Publisher") String editorial,
        @JsonAlias("ISBN") String isbn,
        @JsonAlias("Pages") String paginas,
        @JsonAlias("villains") List<DatoVillano> villano
) {
}
