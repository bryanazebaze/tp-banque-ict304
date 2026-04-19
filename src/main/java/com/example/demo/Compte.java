package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comptes") // Nom de la table dans MySQL
public class Compte {

    @Id
    private String id;
    private String nomProprietaire;
    private String nomBanque; // Pour Orange, MTN, CCA, etc.
    private double solde;

    // Constructeur vide (Obligatoire pour JPA)
    public Compte() {
    }

    public Compte(String id, String nomProprietaire, String nomBanque, double solde) {
        this.id = id;
        this.nomProprietaire = nomProprietaire;
        this.nomBanque = nomBanque;
        this.solde = solde;
    }

    // Getters et Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNomProprietaire() { return nomProprietaire; }
    public void setNomProprietaire(String nomProprietaire) { this.nomProprietaire = nomProprietaire; }

    public String getNomBanque() { return nomBanque; }
    public void setNomBanque(String nomBanque) { this.nomBanque = nomBanque; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
}