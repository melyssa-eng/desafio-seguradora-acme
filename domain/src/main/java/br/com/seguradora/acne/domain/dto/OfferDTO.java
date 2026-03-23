package br.com.seguradora.acne.domain.dto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record OfferDTO(String id,
                       String productId,
                       String name,
                       LocalDateTime createdAt,
                       Boolean active,
                       CoverageDTO coverages,
                       List<String> assistances,
                       MonthlyPremiumAmountDTO monthlyPremiumAmount){}