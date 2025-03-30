package serveur.service.documents;

import serveur.service.Abonne;
import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;

import java.time.LocalTime;

public interface IEtatDocument {
    IEtatDocument reserver(Abonne ab) throws ReservationException;
    IEtatDocument emprunter(Abonne ab) throws EmpruntException;
    IEtatDocument retourner();
    LocalTime getReservationExpiration();
}