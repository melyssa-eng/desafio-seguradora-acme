package br.com.seguradora.acne.adapter.port.in.controller;

import br.com.seguradora.acne.application.port.in.QuoteRequestPortIn;
import br.com.seguradora.acne.domain.dto.QuoteRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("v1")
@RestController
public class QuoteRequestController {

    private final QuoteRequestPortIn portIn;

    @PostMapping("quote_request")
    public ResponseEntity<Object> guoteRequest(@RequestBody QuoteRequestDTO request) {
        return ResponseEntity.ok(portIn.quoteRequest(request));
    }
}
