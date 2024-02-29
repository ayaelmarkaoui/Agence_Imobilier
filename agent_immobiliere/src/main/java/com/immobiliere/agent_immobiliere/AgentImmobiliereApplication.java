package com.immobiliere.agent_immobiliere;

import com.immobiliere.agent_immobiliere.Services.BienImmo_Service;
import com.immobiliere.agent_immobiliere.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class AgentImmobiliereApplication implements CommandLineRunner {
	@Autowired
	private BienImmo_Service bienImmobilierService;


	public static void main(String[] args) {
		SpringApplication.run(AgentImmobiliereApplication.class, args);
	}
	@Override
	public void run(String... args) {
		// Testez les fonctionnalités du service et du contrôleur ici
		Role role = new Role(null, "CUSTOMER");
		Role role2 = new Role(null, "CUSTOMER");
		Collection<Role> roleList = new ArrayList<>();
		roleList.add(role);
		roleList.add(role2);


		// Exemple de création d'un nouveau bien immobilier
		Bien_immobilier nouveauBien = new Bien_immobilier();
		Agence_immobilier agenceImmobilier = new Agence_immobilier();
		User user = new User(null, "aya elmarkaoui","Aya123", roleList, agenceImmobilier);
		List<User> userList = new ArrayList<>();
		userList.add(user);
		agenceImmobilier.setUsers(userList);
		nouveauBien.setLocalisation_BI("Quelque part");
		nouveauBien.setEnumType(ImmobilierType.APPARTEMENT);
		nouveauBien.setEtat_du_bien("Neuf");
		nouveauBien.setPrix_achat(200000.0);
		nouveauBien.setLoyer_mensuel(1000.0);
		nouveauBien.setCharge_mensuel(200.0);
		nouveauBien.setNbr_visite(0);


		bienImmobilierService.createBienImmobilier(nouveauBien);
		Bien_immobilier nouveauBien2 = new Bien_immobilier();
		nouveauBien2.setLocalisation_BI("Quelque part");
		nouveauBien2.setEnumType(ImmobilierType.TERRAIN);
		nouveauBien2.setEtat_du_bien("Neuf");
		nouveauBien2.setPrix_achat(1200000.0);
		nouveauBien2.setLoyer_mensuel(10000.0);
		nouveauBien2.setCharge_mensuel(2000.0);
		nouveauBien2.setNbr_visite(10);

		bienImmobilierService.createBienImmobilier(nouveauBien2);
			List<Bien_immobilier> bienImmobiliers = new ArrayList<>();
			bienImmobiliers.add(nouveauBien);
			bienImmobiliers.add(nouveauBien2);
			agenceImmobilier.setImmobiliers(bienImmobiliers);
			nouveauBien.setAgence(agenceImmobilier);

		// Exemple de récupération de tous les biens immobiliers
		List<Bien_immobilier> tousLesBiens = bienImmobilierService.getAllBiensImmobilier();
		System.out.println("Tous les biens immobiliers : " + tousLesBiens);

	/*	// Exemple de mise à jour d'un bien immobilier existant
		Bien_immobilier bienAUpdate = bienImmobilierService.getBienImmobilierByNum(1L);
		if (bienAUpdate != null) {
			bienAUpdate.setLoyer_mensuel(1200.0);
			bienImmobilierService.updateBienImmobilier(1L, bienAUpdate);
		}

		// Exemple de suppression d'un bien immobilier
		bienImmobilierService.deleteBienImmobilier(2L);

		// Vérifiez les résultats dans la console*/
	}
}
