package br.com.seguradora.acne.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "tbl_coverage")
public class CoverageEntity {
    @Id
    private Long id;
    private Double fire;

    @Column(name = "natural_disasters")
    private Double naturalDisasters;

    @Column(name = "civil_liability")
    private Double civilLiability;

    private Double theft;
}