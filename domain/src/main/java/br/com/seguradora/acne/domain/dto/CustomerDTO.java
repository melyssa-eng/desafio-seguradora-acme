package br.com.seguradora.acne.domain.dto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CustomerDTO (String documentNumber,
                           String name,
                           String type,
                           String gender,
                           LocalDate dateOfBirth,
                           String email,
                           String phoneNumber){
}
