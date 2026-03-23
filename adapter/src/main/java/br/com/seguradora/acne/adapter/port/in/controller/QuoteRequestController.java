package br.com.seguradora.acne.adapter.port.in.controller;

import br.com.seguradora.acne.application.port.in.QuoteRequestPortIn;
import br.com.seguradora.acne.domain.dto.QuoteRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
