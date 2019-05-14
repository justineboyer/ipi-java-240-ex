package com.ipiecoles.java.java240;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String intitule;

    private Double prixEuro;

    public Produit(){
    }

    public Produit(String intitule, Double prixEuro) {
        this.intitule = intitule;
        this.prixEuro = prixEuro;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Double getPrixEuro() {
        return prixEuro;
    }

    public void setPrixEuro(Double prixEuro) {
        this.prixEuro = prixEuro;
    }

    @Override
    public String toString() {
        return "Produit : " +
                "'" + intitule + '\'' +
                ", prix : " + prixEuro +
                '€';
    }
}
