package br.com.seguradora.acne.application.port.out;

import br.com.seguradora.acne.domain.dto.ResponseSearchProductDTO;

import java.util.Optional;

public interface SearchProductPortOut {
    Optional<ResponseSearchProductDTO> searchProduct(String productId);
}
