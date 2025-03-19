package serveur.document;

public class Abonne {
    private int numero;
    private String nom;
    private String dateNaissance;

    public Abonne(int numero, String nom, String dateNaissance) {
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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


}
