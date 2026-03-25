package br.com.seguradora.acne.adapter.repository;

import br.com.seguradora.acne.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
