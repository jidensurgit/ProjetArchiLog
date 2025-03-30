package serveur.service;

import java.net.Socket;

public class ServiceRetour extends ServiceMediateque {

    public ServiceRetour(Socket socket, Mediateque mediateque) {
        super(socket, mediateque);
    }

    @Override
    public String traiterDemande(String [] parameters) {
        IDocument doc = getMediateque().getDocumentById(Integer.parseInt(parameters[0]));
        doc.retourner();
        return doc.titre() + " vient d'être retourné";

    }

    @Override
    public String getServiceNom() {
        return "retour";
    }

    @Override
    public String getServiceVerbe() {
        return "retourner";
    }

    @Override
    public String getServiceFormatCommande() {
        return "<n°document>";
    }

    @Override
    public boolean areValidParameters(String[] parameters) {
        return parameters.length == 1 && parameters[0].matches("[0-9]+");
    }
}