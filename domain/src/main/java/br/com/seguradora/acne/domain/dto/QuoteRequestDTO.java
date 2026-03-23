package br.com.seguradora.acne.domain.dto;


import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record QuoteRequestDTO(String productId,
                              String offerId,
                              String category,
                              Double totalMonthlyPremiumAmount,
                              Double totalCoverageAmount,
                              CoverageDTO coverages,
                              List<String> assistances,
                              CustomerDTO customer) {}