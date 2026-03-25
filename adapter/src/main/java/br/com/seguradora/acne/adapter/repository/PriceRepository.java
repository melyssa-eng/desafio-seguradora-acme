package br.com.seguradora.acne.adapter.repository;

import br.com.seguradora.acne.domain.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, String> {}
