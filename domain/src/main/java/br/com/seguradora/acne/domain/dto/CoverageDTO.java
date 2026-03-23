package br.com.seguradora.acne.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CoverageDTO(
        @JsonProperty("Incêndio")
        Double fire,
        @JsonProperty("Desastres naturais")
        Double naturalDisasters,
        @JsonProperty("Responsabiliadade civil")
        Double civilLiability,
        @JsonProperty("Roubo")
        Double theft) {}
