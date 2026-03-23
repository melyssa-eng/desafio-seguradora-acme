package br.com.seguradora.acne.adapter.handler;

import br.com.seguradora.acne.application.exception.GenericException;
import br.com.seguradora.acne.domain.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerController {

@ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorDTO> handlerGenericException(GenericException e) {
        return  ResponseEntity.status(e.getStatus()).body(new ErrorDTO(e.getStatus().value(), e.getMessage()));

    }
}
