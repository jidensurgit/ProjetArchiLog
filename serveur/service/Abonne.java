package serveur.service;

import java.time.LocalDate;
import java.time.Period;

public class Abonne {
    private int numero;
    private String nom;
    private LocalDate dateNaissance;

    public Abonne(int numero, String nom, LocalDate dateNaissance) {
        this.numero = numero;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean isAdulte() {
        return Period.between(getDateNaissance(), LocalDate.now()).getYears() >= 16;
    }

}
