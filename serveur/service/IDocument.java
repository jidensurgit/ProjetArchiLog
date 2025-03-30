package serveur.service;

import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;
import serveur.service.documents.IEtatDocument;

public interface IDocument {
    int numero();
    String titre();
    IEtatDocument getEtat();
    // exception si déjà réservé ou emprunté
    void reserver (Abonne ab) throws ReservationException;
    // exception si réservé pour une autre abonné ou déjà emprunté
    void emprunter(Abonne ab) throws EmpruntException;
    // sert au retour d’un document ou à l’annulation d‘une réservation
    void retourner();
}
