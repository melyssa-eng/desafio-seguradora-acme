package br.com.seguradora.acne.application.usecase;

import br.com.seguradora.acne.application.exception.GenericException;
import br.com.seguradora.acne.application.exception.GenericListException;
import br.com.seguradora.acne.application.port.in.QuoteRequestPortIn;
import br.com.seguradora.acne.application.port.out.SearchOfferPortOut;
import br.com.seguradora.acne.application.port.out.SearchProductPortOut;
import br.com.seguradora.acne.domain.dto.*;
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
        List<String> erros = validateOffer(product, offer, request);
        if(!erros.isEmpty()) throw new GenericListException(HttpStatus.BAD_REQUEST, erros, "Foi encontrado erros na requisição");
        return List.of(product, offer);
    }

    private List<String> validateOffer(Optional<ResponseSearchProductDTO> product, Optional<OfferDTO> offer, QuoteRequestDTO request) {
        try {
            List<String> erros = new ArrayList();

            if(!(product.isPresent() && offer.isPresent()  && product.get().active() && offer.get().active())) {
                erros.add("Não foi encontrado nenhuma Oferta ou Produtos com as informações recebida");
                return erros;
            }

            if(Optional.ofNullable(request.coverages().fire()).orElse(0.0) >= offer.get().coverages().fire())
                erros.add("Valor informado da cobertura de incêndio recebido é maior do que o a oferta pode oferecer ".concat(offer.get().coverages().fire().toString()));

            if(Optional.ofNullable(request.coverages().naturalDisasters()).orElse(0.0) >= offer.get().coverages().naturalDisasters())
                erros.add("Valor informado da cobertura do desastre natural recebido é maior do que o a oferta pode oferecer ".concat(offer.get().coverages().naturalDisasters().toString()));

            if(Optional.ofNullable(request.coverages().civilLiability()).orElse(0.0) >= offer.get().coverages().civilLiability())
                erros.add("Valor informado da cobertura da responsabilidade civil recebido é maior do que o a oferta pode oferecer ".concat(offer.get().coverages().civilLiability().toString()));

            if(Optional.ofNullable(request.coverages().theft()).orElse(0.0) >= offer.get().coverages().theft())
                erros.add("Valor informado da cobertura por roubo recebido é maior do que o a oferta pode oferecer ".concat(offer.get().coverages().theft().toString()));

            if(Optional.ofNullable(request.totalMonthlyPremiumAmount()).orElse(0.0) <= offer.get().monthlyPremiumAmount().minAmount())
                erros.add("O valor mensal total do prêmio é inferior ao valor mensal mínimo ofertado ".concat(offer.get().monthlyPremiumAmount().minAmount().toString()));

            if(Optional.ofNullable(request.totalMonthlyPremiumAmount()).orElse(0.0) >= offer.get().monthlyPremiumAmount().maxAmount())
                erros.add("O valor mensal total do prêmio é maior que o valor mensal máximo ofertado ".concat(offer.get().monthlyPremiumAmount().maxAmount().toString()));

            List<String> erroAssistances = (validateAssistances(offer.get(), request));

            if(!erroAssistances.isEmpty())
                erros.add("A oferta não possue uma das assistencias informada: ".concat(erroAssistances.toString()));

            return erros;
        }
        catch (Exception e) {
            throw new GenericException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocorreu um erro ao tentar realizar a validação do payload");
        }
    }

    private List<String>  validateAssistances(OfferDTO offer, QuoteRequestDTO request) {
        List<String> listAssistance = new  ArrayList<>();
        for (String assistance : request.assistances()){
           if(!offer.assistances().stream().map(String::toLowerCase).toList().contains(assistance.toLowerCase()))
               listAssistance.add(assistance);
        }
        return listAssistance;
    }
}
