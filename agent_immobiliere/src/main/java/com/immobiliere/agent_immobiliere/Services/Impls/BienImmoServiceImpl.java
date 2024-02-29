package com.immobiliere.agent_immobiliere.Services.Impls;

import com.immobiliere.agent_immobiliere.Repos.Bien_immobilierRepo;
import com.immobiliere.agent_immobiliere.Services.BienImmo_Service;
import com.immobiliere.agent_immobiliere.entities.Bien_immobilier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BienImmoServiceImpl implements BienImmo_Service {
    @Autowired
    private Bien_immobilierRepo bienImmobilierRepository;

    // Obtient la liste de tous les biens immobiliers
    @Override
    public List<Bien_immobilier> getAllBiensImmobilier() {
        return bienImmobilierRepository.findAll();
    }

    // Obtient un bien immobilier par son numéro
    @Override
    public Bien_immobilier getBienImmobilierByNum(Long num_BI) {
        return bienImmobilierRepository.findById(num_BI).orElse(null);
    }

    // Crée un nouveau bien immobilier
    @Override
    public Bien_immobilier createBienImmobilier(Bien_immobilier bienImmobilier) {
        return bienImmobilierRepository.save(bienImmobilier);
    }

    // Met à jour un bien immobilier existant
    @Override
    public Bien_immobilier updateBienImmobilier(Long num_BI, Bien_immobilier updatedBienImmobilier) {
        Bien_immobilier existingBienImmobilier = bienImmobilierRepository.findById(num_BI).orElse(null);

        if (existingBienImmobilier != null) {
            existingBienImmobilier.setLocalisation_BI(updatedBienImmobilier.getLocalisation_BI());
            existingBienImmobilier.setEnumType(updatedBienImmobilier.getEnumType());
            existingBienImmobilier.setEtat_du_bien(updatedBienImmobilier.getEtat_du_bien());
            existingBienImmobilier.setPrix_achat(updatedBienImmobilier.getPrix_achat());
            existingBienImmobilier.setLoyer_mensuel(updatedBienImmobilier.getLoyer_mensuel());
            existingBienImmobilier.setCharge_mensuel(updatedBienImmobilier.getCharge_mensuel());
            existingBienImmobilier.setNbr_visite(updatedBienImmobilier.getNbr_visite());

            return bienImmobilierRepository.save(existingBienImmobilier);
        }

        return null;
    }

    // Supprime un bien immobilier
    @Override
    public void deleteBienImmobilier(Long num_BI) {
        bienImmobilierRepository.deleteById(num_BI);
    }
}
