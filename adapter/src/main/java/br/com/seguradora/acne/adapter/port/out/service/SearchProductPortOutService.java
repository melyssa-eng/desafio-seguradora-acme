package br.com.seguradora.acne.adapter.port.out.service;

import br.com.seguradora.acne.adapter.port.out.feign.ProductFeign;
import br.com.seguradora.acne.application.exception.GenericException;
import br.com.seguradora.acne.application.port.out.SearchProductPortOut;
import br.com.seguradora.acne.domain.dto.ResponseSearchProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SearchProductPortOutService implements SearchProductPortOut {

    private final ProductFeign feignService;

    @Override
    public Optional<ResponseSearchProductDTO> searchProduct(String productId) {
        try {
             return feignService.searchProduct(productId);
        }
        catch (Exception e) {
            throw new GenericException(HttpStatus.BAD_REQUEST, "Produto não encontrado");
        }
    }
}
