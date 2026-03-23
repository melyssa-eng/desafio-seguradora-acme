package br.com.seguradora.acne.application.port.in;

import br.com.seguradora.acne.domain.dto.QuoteRequestDTO;

public interface QuoteRequestPortIn {
    Object quoteRequest(QuoteRequestDTO request);
}
