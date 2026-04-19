package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String> {
    // Le nom de la méthode définit la requête SQL automatiquement
    boolean existsByNomProprietaireAndNomBanque(String nomProprietaire, String nomBanque);
}