package br.com.seguradora.acne.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class GenericListException extends RuntimeException {
    private HttpStatus status;
    private List<String> listErrors;

    public GenericListException(HttpStatus status, List<String> listErrors, String messsage){
        super(messsage);
        this.status = status;
        this.listErrors = listErrors;
    }
}
