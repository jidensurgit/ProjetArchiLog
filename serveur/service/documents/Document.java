package serveur.service.documents;

import serveur.service.Abonne;
import serveur.service.IDocument;
import serveur.service.documents.etat.Disponible;
import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;

public abstract class Document implements IDocument {
    private final int num;
    private final String title;

    private IEtatDocument etat;

    public Document(int num, String title) {
        this.num = num;
        this.title = title;
        etat = new Disponible();
    }

    @Override
    public int numero() {
        return num;
    }

    @Override
    public String titre() {
        return title;
    }

    @Override
    public IEtatDocument getEtat() {
        return etat;
    }

    @Override
    public synchronized void reserver (Abonne ab) throws ReservationException {
        etat = etat.reserver(ab);
    }

    @Override
    public synchronized void emprunter(Abonne ab) throws EmpruntException {
        etat = etat.emprunter(ab);
    }

    // sert au retour d’un document ou à l’annulation d‘une réservation
    public synchronized void retourner() {
        etat = etat.retourner();
    }
}
