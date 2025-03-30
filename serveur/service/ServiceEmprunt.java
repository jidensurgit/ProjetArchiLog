package serveur.service;

import serveur.service.documents.etat.exception.EmpruntException;

import java.net.Socket;

public class ServiceEmprunt extends ServiceMediateque {

    public ServiceEmprunt(Socket socket, Mediateque mediateque) {
        super(socket, mediateque);
    }

    @Override
    public String traiterDemande(String [] parameters) throws EmpruntException {
        Abonne ab = getMediateque().getAbonneById(Integer.parseInt(parameters[0]));
        IDocument doc = getMediateque().getDocumentById(Integer.parseInt(parameters[1]));
        doc.emprunter(ab);
        return ab.getNom() + " emprunte " + doc.titre();

    }

    @Override
    public String getServiceNom() {
        return "emprunt";
    }

    @Override
    public String getServiceVerbe() {
        return getServiceNom() + "er";
    }
}