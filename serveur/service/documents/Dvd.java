package serveur.service.documents;

import serveur.service.Abonne;
import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;

public class Dvd extends Document {
    private final boolean adulte;

    public Dvd(int num, String title, boolean adulte) {
        super(num, title);
        this.adulte = adulte;
    }

    @Override
    public void reserver(Abonne ab) throws ReservationException {
        if (adulte && !ab.isAdulte())
            throw new ReservationException("Vous n'avez pas l'âge pour réserver ce DVD.");
        super.reserver(ab);
    }

    @Override
    public void emprunter(Abonne ab) throws EmpruntException {
        if (adulte && !ab.isAdulte())
            throw new EmpruntException("Vous n'avez pas l'âge pour emprunter ce DVD.");
        super.emprunter(ab);
    }

    @Override
    public String toString() {
        return "dvd";
    }
}
