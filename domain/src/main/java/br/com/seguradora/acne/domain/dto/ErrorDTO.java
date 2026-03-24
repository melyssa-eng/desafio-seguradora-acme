package br.com.seguradora.acne.domain.dto;

import java.util.List;

public record ErrorDTO(int code, String message, List<String> detail) {
}
