package com.immobiliere.agent_immobiliere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id_user;
    private String Nom_complet;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)// #LAZY si je charge les donnees d'utilisateur de la bdd il ne va pas charger les donnes des roles d'une maniere automatique
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id",referencedColumnName = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))

    private Collection<Role> Roles=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "agence_id")
    private Agence_immobilier agence;

}
