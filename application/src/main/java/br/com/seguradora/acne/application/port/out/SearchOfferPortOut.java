package br.com.seguradora.acne.application.port.out;

import br.com.seguradora.acne.domain.dto.OfferDTO;

import java.util.Optional;

public interface SearchOfferPortOut {
    Optional<OfferDTO> searchOffer(String offerId);
}
