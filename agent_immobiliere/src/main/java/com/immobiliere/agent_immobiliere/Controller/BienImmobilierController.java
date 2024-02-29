package com.immobiliere.agent_immobiliere.Controller;


import com.immobiliere.agent_immobiliere.Services.BienImmo_Service;
import com.immobiliere.agent_immobiliere.entities.Bien_immobilier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bien-immobilier")
public class BienImmobilierController {
    @Autowired
    private BienImmo_Service bienImmobilierService;
    @GetMapping("/all")
    public ResponseEntity<List<Bien_immobilier>> getAllBiensImmobilier() {
        List<Bien_immobilier> biensImmobilier = bienImmobilierService.getAllBiensImmobilier();
        return new ResponseEntity<>(biensImmobilier, HttpStatus.OK);
    }

    // Endpoint pour obtenir un bien immobilier par son numéro
    @GetMapping("/{num_BI}")
    public ResponseEntity<Bien_immobilier> getBienImmobilierByNum(@PathVariable Long num_BI) {
        Bien_immobilier bienImmobilier = bienImmobilierService.getBienImmobilierByNum(num_BI);
        if (bienImmobilier != null) {
            return new ResponseEntity<>(bienImmobilier, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour créer un nouveau bien immobilier
    @PostMapping("/create")
    public ResponseEntity<Bien_immobilier> createBienImmobilier(@RequestBody Bien_immobilier bienImmobilier) {
        Bien_immobilier newBienImmobilier = bienImmobilierService.createBienImmobilier(bienImmobilier);
        return new ResponseEntity<>(newBienImmobilier, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un bien immobilier existant
    @PutMapping("/update/{num_BI}")
    public ResponseEntity<Bien_immobilier> updateBienImmobilier(
            @PathVariable Long num_BI,
            @RequestBody Bien_immobilier updatedBienImmobilier) {
        Bien_immobilier updatedBien = bienImmobilierService.updateBienImmobilier(num_BI, updatedBienImmobilier);
        if (updatedBien != null) {
            return new ResponseEntity<>(updatedBien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un bien immobilier
    @DeleteMapping("/delete/{num_BI}")
    public ResponseEntity<Void> deleteBienImmobilier(@PathVariable Long num_BI) {
        bienImmobilierService.deleteBienImmobilier(num_BI);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
