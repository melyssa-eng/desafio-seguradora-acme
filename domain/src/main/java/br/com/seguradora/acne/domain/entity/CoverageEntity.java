package br.com.seguradora.acne.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "tbl_coverage")
public class CoverageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
    @SequenceGenerator(
            name = "tbl_coverage_seq",
            sequenceName = "tbl_coverage_seq", // The actual name in the DB
            allocationSize = 100 // Improves performance by reducing DB calls
    )
    private Long id;
    private Double fire;

    @Column(name = "natural_disasters")
    private Double naturalDisasters;

    @Column(name = "civil_liability")
    private Double civilLiability;

    private Double theft;
}