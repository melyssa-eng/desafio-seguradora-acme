package br.com.seguradora.acne.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "tbl_priece")
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_entity_seq")
    @SequenceGenerator(
            name = "tbl_priece_seq",
            sequenceName = "tbl_priece_seq", // The actual name in the DB
            allocationSize = 100 // Improves performance by reducing DB calls
    )
    private Long id;

    @Column(name = "insurance_policy_id")
    private Integer insurancePolicyId;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "offer_id")
    private String offerId;

    private String category;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "total_monthly_premium_amount")
    private Double totalMonthlyPremiumAmount;

    @Column(name = "total_coverage_amount")
    private Double totalCoverageAmount;

    @OneToOne
    private CoverageEntity coverages;

    @OneToOne
    private CustomerEntity customer;

    @ManyToMany
    private List<AssistanceEntity> assistances;
}