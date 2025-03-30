package serveur.service.documents.etat;

import serveur.service.documents.IEtatDocument;

import java.time.LocalTime;

public abstract class EtatDocument implements IEtatDocument {

    @Override
    public IEtatDocument retourner() {
        return new Disponible();
    }

    @Override
    public LocalTime getReservationExpiration() {
        throw new UnsupportedOperationException("Le document n'a pas été réservé");

    }
}
