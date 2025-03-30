package serveur.service;

import serveur.service.documents.etat.exception.ReservationException;

import java.net.Socket;

public class ServiceReservation extends ServiceMediateque {

    public ServiceReservation(Socket socket, Mediateque mediateque) {
        super(socket, mediateque);
    }

    @Override
    public String traiterDemande(String [] parameters) throws ReservationException {
        Abonne ab = getMediateque().getAbonneById(Integer.parseInt(parameters[0]));
        IDocument doc = getMediateque().getDocumentById(Integer.parseInt(parameters[1]));
        doc.reserver(ab);
        return ab.getNom() + " réserve " + doc.titre() + " jusqu'à " +
                doc.getEtat().getReservationExpiration().toString().substring(0, 5);
    }

    @Override
    public String getServiceNom() {
        return "réservation";
    }

    @Override
    public String getServiceVerbe() {
        return "réserver";
    }
}