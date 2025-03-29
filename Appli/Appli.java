package Appli;

import serveur.Serveur;
import serveur.Service;

import java.io.IOException;

public class Appli {

    private final static int PORT_RESERVATION = 2000;
    private final static int PORT_EMPRUNT = 3000;
    private final static int PORT_RETOUR = 4000;

    public static void main(String[] args) {
        try {
            new Thread(new Serveur(PORT_RESERVATION, Service.class)).start();
            new Thread(new Serveur(PORT_EMPRUNT, Service.class)).start();
            new Thread(new Serveur(PORT_RETOUR, Service.class)).start();
        } catch (IOException e) {

        }
    }
}
