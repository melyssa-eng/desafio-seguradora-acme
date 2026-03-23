package br.com.seguradora.acne.domain.dto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ResponseSearchProductDTO(String id,
                                       String name,
                                       LocalDateTime createdAt,
                                       Boolean active,
                                       List<String> offers) {
}
