package serveur.service.documents.etat;

import serveur.service.Abonne;
import serveur.service.documents.IEtatDocument;
import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;

import java.time.LocalTime;

public class Reserve extends EtatDocument {

    private Abonne reserveur;
    private LocalTime dateReservation;

    public Reserve(Abonne reserveur, LocalTime dateReservation) {
        super();
        this.reserveur = reserveur;
        this.dateReservation = dateReservation;
    }

    @Override
    public LocalTime getReservationExpiration() {
        return dateReservation.plusHours(1);
    }

    @Override
    public IEtatDocument reserver(Abonne ab) throws ReservationException {
        if (!estExpireeReservation())
            throw new ReservationException("Ce document est réservé jusqu'à " +
                    dateReservation.plusHours(1).getHour() + "h" +
                    dateReservation.plusHours(1).getMinute());
        reserveur = ab;
        dateReservation = LocalTime.now();
        return this;
    }

    @Override
    public IEtatDocument emprunter(Abonne ab) throws EmpruntException {
        if (!estExpireeReservation() && reserveur != ab)
            throw new EmpruntException("Ce document est réservé jusqu'à " +
                    dateReservation.plusHours(1).getHour() + "h" +
                    dateReservation.plusHours(1).getMinute());
        return new Emprunte();
    }

    private boolean estExpireeReservation() {
        return dateReservation.plusHours(1).isBefore(LocalTime.now());
    }
}
