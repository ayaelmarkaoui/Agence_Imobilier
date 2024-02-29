package com.immobiliere.agent_immobiliere.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Agence")
public class Agence_immobilier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "agence", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    private List<User> users;

    @OneToMany(mappedBy = "agence", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "num_BI", referencedColumnName = "num_BI")
    private List<Bien_immobilier> immobiliers;

}
