package br.com.seguradora.acne.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GenericException extends RuntimeException {
    private HttpStatus status;

    public GenericException(HttpStatus status, String message){
        super(message);
        this.status = status;
    }
}
