package br.com.seguradora.acne.domain.dto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record MonthlyPremiumAmountDTO(Double maxAmount,
                                      Double minAmount,
                                      Double SuggestedAmount) {
}
