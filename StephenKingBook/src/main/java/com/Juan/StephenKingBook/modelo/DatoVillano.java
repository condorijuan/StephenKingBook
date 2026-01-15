package com.Juan.StephenKingBook.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatoVillano(
    @JsonAlias("name") String nombre
) {
}
