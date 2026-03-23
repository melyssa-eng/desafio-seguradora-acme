package br.com.seguradora.acne.application.usecase;

import br.com.seguradora.acne.application.exception.GenericException;
import br.com.seguradora.acne.application.port.in.QuoteRequestPortIn;
import br.com.seguradora.acne.application.port.out.SearchOfferPortOut;
import br.com.seguradora.acne.application.port.out.SearchProductPortOut;
import br.com.seguradora.acne.domain.dto.MonthlyPremiumAmountDTO;
import br.com.seguradora.acne.domain.dto.OfferDTO;
import br.com.seguradora.acne.domain.dto.QuoteRequestDTO;
import br.com.seguradora.acne.domain.dto.ResponseSearchProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class QuoteRequestUseCase implements QuoteRequestPortIn {

    private final SearchProductPortOut productPortOut;
    private final SearchOfferPortOut offerPortOut;

    @Override
    public Object quoteRequest(QuoteRequestDTO request) {

        Optional<ResponseSearchProductDTO> product = productPortOut.searchProduct(request.productId());
        Optional<OfferDTO> offer = offerPortOut.searchOffer(request.offerId());
        if(!validateOffer(product, offer, request)) return List.of();
        return List.of(product, offer);
    }

    private boolean validateOffer(Optional<ResponseSearchProductDTO> product, Optional<OfferDTO> offer, QuoteRequestDTO request) {
        return  product.isPresent() &&
                product.get().active() &&
                offer.isPresent() &&
                offer.get().active() &&
                request.coverages().fire() <= offer.get().coverages().fire() &&
                request.coverages().naturalDisasters() <= offer.get().coverages().naturalDisasters() &&
                request.coverages().civilLiability() <= offer.get().coverages().civilLiability() &&
                request.coverages().theft() <= offer.get().coverages().theft()  &&
                request.totalMonthlyPremiumAmount() <= offer.get().monthlyPremiumAmount().maxAmount() &&
                request.totalCoverageAmount() >= offer.get().monthlyPremiumAmount().minAmount() &&
                validateAssistances(offer.get(), request);
    }


    private boolean validateAssistances(OfferDTO offer, QuoteRequestDTO request) {
        boolean ok = true;
        for (String assistance : request.assistances()){
           if(!offer.assistances().stream().map(String::toLowerCase).toList().contains(assistance.toLowerCase())) return false;
        }
        return ok;
    }
}
