package br.com.seguradora.acne.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_assistance")
public class AssistanceEntity {
    @Id
    private String name;
}