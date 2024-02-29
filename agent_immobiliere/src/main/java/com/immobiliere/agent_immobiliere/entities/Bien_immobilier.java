package com.immobiliere.agent_immobiliere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Bien_immobilier")
public class Bien_immobilier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_BI")
    private Long num_BI;
    private String localisation_BI;
    private ImmobilierType EnumType;
    private String Etat_du_bien;
    private Double prix_achat;
    private Double loyer_mensuel;
    private Double charge_mensuel;
    private int nbr_visite;
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence_immobilier agence;

}
