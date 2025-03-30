package serveur.service.documents.etat;

import serveur.service.Abonne;
import serveur.service.documents.IEtatDocument;
import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;

public class Emprunte extends EtatDocument {

    public Emprunte() {
        super();
    }

    @Override
    public IEtatDocument reserver(Abonne ab) throws ReservationException {
        throw new ReservationException("Ce document est déjà emprunté");
    }

    @Override
    public IEtatDocument emprunter(Abonne ab) throws EmpruntException {
        throw new EmpruntException("Ce document est déjà emprunté");
    }

}
