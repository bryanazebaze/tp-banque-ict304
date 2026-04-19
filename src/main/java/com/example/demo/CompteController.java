package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    @Autowired
    private CompteRepository compteRepository;

    // API : Afficher la liste de TOUS les comptes (depuis MySQL)
    @GetMapping
public String getTousLesComptes() {
    List<Compte> comptes = compteRepository.findAll();
    
    if (comptes.isEmpty()) return "Aucun compte trouvé.";

    StringBuilder sb = new StringBuilder();
    String border = "+--------------------------------------+-----------------+------------+------------+\n";
    String header = "| ID                                   | Propriétaire    | Banque     | Solde      |\n";
    
    sb.append(border).append(header).append(border);

    for (Compte c : comptes) {
        sb.append(String.format("| %-36s | %-15s | %-10s | %-10.2f |\n", 
            c.getId(), 
            c.getNomProprietaire(), 
            c.getNomBanque(), 
            c.getSolde()));
    }
    
    sb.append(border);
    return sb.toString();
}

// API : Créer un nouveau compte (dans MySQL)
@PostMapping
public Compte creerCompte(@RequestBody Compte nouveauCompte) {
    // On appelle le nouveau nom exact de la méthode
    boolean existeDeja = compteRepository.existsByNomProprietaireAndNomBanque(
        nouveauCompte.getNomProprietaire(), 
        nouveauCompte.getNomBanque()
    );

    if (existeDeja) {
        throw new RuntimeException("Un compte existe déjà pour ce propriétaire chez " + nouveauCompte.getNomBanque());
    }

    nouveauCompte.setId(UUID.randomUUID().toString());
    return compteRepository.save(nouveauCompte);
}
}