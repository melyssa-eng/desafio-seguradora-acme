package br.com.seguradora.acne.adapter.repository;

import br.com.seguradora.acne.domain.entity.CoverageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverageRepository extends JpaRepository<CoverageEntity, Long> {
}
