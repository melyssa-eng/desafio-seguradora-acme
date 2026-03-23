package br.com.seguradora.acne.adapter.port.out.feign;

import br.com.seguradora.acne.domain.dto.OfferDTO;
import br.com.seguradora.acne.domain.dto.ResponseSearchProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@FeignClient(name = "ApiDadosFeign", url = "${api-dados.url}")
public interface ProductFeign {

    @PostMapping("/search-product/{idProduct}")
    Optional<ResponseSearchProductDTO> searchProduct(@PathVariable String idProduct);

    @PostMapping("/search-offer/{offerId}")
    Optional<OfferDTO> searchOffer(@PathVariable String offerId);
}
