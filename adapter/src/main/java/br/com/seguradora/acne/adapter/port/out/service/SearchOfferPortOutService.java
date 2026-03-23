package br.com.seguradora.acne.adapter.port.out.service;

import br.com.seguradora.acne.adapter.port.out.feign.ProductFeign;
import br.com.seguradora.acne.application.exception.GenericException;
import br.com.seguradora.acne.application.port.out.SearchOfferPortOut;
import br.com.seguradora.acne.domain.dto.OfferDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SearchOfferPortOutService implements SearchOfferPortOut {
    private final ProductFeign feignService;

    @Override
    public Optional<OfferDTO> searchOffer(String offerId) {
        try {
            return feignService.searchOffer(offerId);
        }
        catch (Exception e) {
            throw new GenericException(HttpStatus.BAD_REQUEST, "Oferta não encontrado");
        }
    }
}
