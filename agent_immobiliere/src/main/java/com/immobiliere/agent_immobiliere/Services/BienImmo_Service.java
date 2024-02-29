package com.immobiliere.agent_immobiliere.Services;

import com.immobiliere.agent_immobiliere.entities.Bien_immobilier;

import java.util.List;

public interface BienImmo_Service {
     List<Bien_immobilier> getAllBiensImmobilier();
     Bien_immobilier getBienImmobilierByNum(Long num_BI);
     Bien_immobilier createBienImmobilier(Bien_immobilier bienImmobilier);
     Bien_immobilier updateBienImmobilier(Long num_BI, Bien_immobilier updatedBienImmobilier);
     void deleteBienImmobilier(Long num_BI);
}
