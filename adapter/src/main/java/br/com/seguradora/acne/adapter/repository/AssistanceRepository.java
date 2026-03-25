package br.com.seguradora.acne.adapter.repository;

import br.com.seguradora.acne.domain.entity.AssistanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistanceRepository extends JpaRepository<AssistanceEntity, String > {
}
