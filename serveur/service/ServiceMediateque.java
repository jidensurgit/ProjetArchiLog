package serveur.service;

import serveur.service.documents.etat.exception.EmpruntException;
import serveur.service.documents.etat.exception.ReservationException;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public abstract class ServiceMediateque extends Service {
    private final Mediateque mediateque;

    public ServiceMediateque(Socket socket, Mediateque mediateque) {
        super(socket);
        this.mediateque = mediateque;
    }

    @Override
    public void run() {
        System.out.println("╔ Connexion " + super.getNumero() + " démarrée:" + super.getClient().getInetAddress());
        System.out.println("╠ Service " + getServiceNom());
        try {
            Scanner in = new Scanner(super.getClient().getInputStream());
            PrintWriter out = new PrintWriter(super.getClient().getOutputStream(), true);
            String input;
            out.println("Bienvenue au service " + getServiceNom());

            do {
                out.println("Saisissez votre numéro d'abonné et le document que vous voulez " + getServiceVerbe() + " ou \"exit\"");
                out.println("Format : " + getServiceFormatCommande());

                input = in.nextLine();

                // L'utilisateur quitte le service
                if (input.equals("exit"))
                    out.println("Fin du service " + getServiceNom());

                    // L'utilisateur a saisi quelque chose...
                else if (!input.isBlank()) {
                    String[] parameters = input.split(" ");

                    // L'utilisateur a saisi des paramètres valides "<int> <int>"
                    if (areValidParameters(parameters)) {
                        try {
                            System.out.println("╠ " + traiterDemande(parameters));
                            out.println(Character.toUpperCase(getServiceNom().charAt(0)) +
                                    getServiceNom().substring(1) + " enregistré");
                        } catch (Exception e) {
                            out.println(e.getMessage());
                        }
                    }
                } else {
                    out.println("Format invalide");
                }
            } while (!input.equals("exit"));
            in.close();
        } catch (IOException _) {
            throw new RuntimeException();
        }
        System.out.println("╚ Connexion " + super.getNumero() + " terminée");
        try {
            super.getClient().close();
        } catch (IOException _) {}
    }

    public Mediateque getMediateque() {
        return mediateque;
    }

    public String getServiceFormatCommande() {
        return "<n°abonne> <n°document>";
    }

    public boolean areValidParameters(String[] parameters) {
        return parameters.length == 2 && parameters[0].matches("[0-9]+") && parameters[1].matches("[0-9]+");
    }

    public String toString() {
        return "";
    }

    public abstract String traiterDemande(String[] parameters) throws ReservationException, EmpruntException;

    public abstract String getServiceNom();

    public abstract String getServiceVerbe();


}
